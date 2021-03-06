package com.codeup.adlister.dao;

import Daos.Config;

import com.codeup.adlister.models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(

                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
 public List<Ad> search(String searchTerm) {
        try{
            PreparedStatement stmt = connection.prepareStatement( "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?");
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");
            ResultSet rs = stmt.executeQuery();
            List ads = new ArrayList();
            while (rs.next()) {
                Long id = rs.getLong("id");
                Long user_id = rs.getLong("user_id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Ad ad = new Ad(id, user_id, title, description);
                ads.add(ad);
            }
            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM ads");
            ResultSet resultSet = statement.executeQuery();
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads", e);

        }
    }

    @Override

    public boolean adsDelete(Long id) { //allow user to delete ads from his profile page
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE  FROM ads where id = ?");
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting this ad");
        }
        return false;
    }

    @Override
    public List<Ad> findByUsername(long user_id) {
        PreparedStatement stmt;

        try{
        stmt = connection.prepareStatement("select * from ads where user_id = ? ");
        stmt.setLong(1,user_id);
        ResultSet rs = stmt.executeQuery();
        return createAdsFromResults(rs);

        } catch (SQLException e){
            throw new RuntimeException("error retrieving your ads");
        }

    }
    @Override
    public List<Ad> searchCategories(int query){
        PreparedStatement stmt = null;
        try {
            String sql = "select * from ads where category = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,query);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch (SQLException e) {
           throw new RuntimeException("Error retrieving ads", e);
        }
    }

    @Override
    public HashMap<Integer, String> getCategories(){
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT  * from categories");
            ResultSet rs = stmt.executeQuery();
            HashMap<Integer, String> toReturn = new HashMap<>();
            while (rs.next()) {
                toReturn.put(rs.getInt(1),rs.getString(2));
            }
            return toReturn;
        }catch (SQLException e) {
            throw new RuntimeException("Error finding categories");

        }
    }

    @Override

    public Long insert(Ad ad) {

        try {
            String query = "INSERT INTO ads(user_id, title, description) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query
                    , Statement.RETURN_GENERATED_KEYS
            );

            statement.setLong(1, ad.getUserId());
            statement.setString(2, ad.getTitle());
            statement.setString(3, ad.getDescription());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet resultSet) throws SQLException {
        return new Ad(
                resultSet.getLong("id"),
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    public void update(Ad ad) {
        try {
            String query = "UPDATE ads SET title=?, description=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query
            );
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setLong(3, ad.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad findById(long id) {
        String SearchQuery = "SELECT * FROM ads WHERE id = ? LIMIT 1";

        try {


            PreparedStatement statement = connection.prepareStatement(SearchQuery);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return  extractAd(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding users", e);
        }
    }

}

