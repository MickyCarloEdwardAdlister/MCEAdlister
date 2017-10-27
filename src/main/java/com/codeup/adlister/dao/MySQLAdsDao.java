package com.codeup.adlister.dao;

import Daos.Config;
import com.codeup.adlister.models.Ad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads{
    private Connection connection = null;

    public MySQLAdsDao(Config config){

     try{
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
    public Long insert(Ad ad){
        String query = "INSERT INTO ads(user_id, title, description) VALUES(?,?,?)";
        try{
        PreparedStatement statement = connection.prepareStatement(query
         ,Statement.RETURN_GENERATED_KEYS
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
}

