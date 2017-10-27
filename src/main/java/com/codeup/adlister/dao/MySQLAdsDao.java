//package com.codeup.adlister.dao;
//
//import Daos.Config;
//import com.codeup.adlister.models.Ad;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;
//import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;
//
//public class MySQLAdsDao implements Ads{
//    private Connection connection;
//
//    public MySQLAdsDao(Config config){
//
//     try{
//         DriverManager.registerDriver(new Driver());
//        Connection = DriverManager.getConnection(
//
//        Config.getUrl(),
//        Config.getUser(),
//        Config.getPassword()
//        );
//    } catch (SQLException e) {
//        throw new RuntimeException("Error connecting to the database!", e);
//       }
//    }
//
//    public List<Ad> all() {
//        PreparedStatement statement;
//
//        try {
//            statement = connection.prepareStatement("SELECT * FROM ads");
//            ResultSet resultSet = statement.executeQuery();
//            return createAdsFromResults(resultSet);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads", e);
//
//        }
//    }
//    public long insert(Ad ad){
//        try{
//        PreparedStatement statement = Connection.preperStatement(
//         "INSERT INTO ads(user_id, title, description) VALUES(?,?,?)",statement.RETURN_GENERATED_KEYS
//        );
//
//        statement.setLong(1, ad.getUserId());
//        statement.setString(2, ad.getTitle());
//        statement.setString(3, ad.getDescription());
//
//        statement.executeUpdate();
//        ResultSet rs = statement.getGeneratedKeys();
//        resulSet.next();
//
//        return resultSet.getLong(1);
//        } catch (SQLException e) {
//        throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
//    private Ad extractAd(ResultSet resultSet) throws SQLException {
//        return new Ad(
//                resultSet.getLong("id"),
//                resultSet.getLong("user_id"),
//                resultSet.getString("title"),
//                resultSet.getString("description")
//        );
//    }
//
//    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        while (rs.next()) {
//            ads.add(extractAd(rs));
//        }
//        return ads;
//    }
//}