package com.codeup.adlister.controllers;

import java.sql.Connection;package com.codeup.adlister.dao;
import Daos.Config;
import com.codeup.adlister.dao.Users;
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
    public User findByUsername(String username)  {
        String SearchQuery = "Select * from Users where username = ?";

        try {


            PreparedStatement statement = connection.prepareStatement(SearchQuery);
            statement.setString(1, username);
            return null;
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding users", e);
        }

    }

    @Override
    public Long insert(User user) {
        String usersCreateQuery = "insert into users(username, email, password) values(?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(usersCreateQuery,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getUsername);
            statement.setString(3,user.getEmail);
            statement.setString(2, user.getPassword);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();


            return rs.getLong(1);


        }catch (SQLException e){
           throw new RuntimeException("Error creating user", e);


        }
    }
    private Users extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null


        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")

        );
        }
    }
