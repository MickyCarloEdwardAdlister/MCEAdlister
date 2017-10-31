package com.codeup.adlister.dao;

import java.sql.Connection;
import Daos.Config;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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

    @Override
    public User findByUsername(String username) {
        String SearchQuery = "SELECT * FROM Users WHERE username = ? LIMIT 1";

        try {


            PreparedStatement statement = connection.prepareStatement(SearchQuery);
            statement.setString(1, username);
            return (User) extractUser(statement.executeQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding users", e);
        }

    }

    @Override
    public Long insert(User user) {
        String createUserQuery = "INSERT INTO users(username, email, password) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(createUserQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();


            return rs.getLong(1);


        } catch (SQLException e) {
            throw new RuntimeException("Error creating user", e);


        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;


        } else {
            return new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")

            );
        }
    }
    public void updateProfile(User user) {
        try {
            String query = "UPDATE users SET email=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query
            );
            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}
