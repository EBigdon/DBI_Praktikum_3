package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost";
            String username = "dbi";
            String password = "dbi_pass";

            System.out.println("Connecting database...");

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost", username, password)) {
                System.out.println("Database connected!");
            } catch (SQLException e) {
                throw new IllegalStateException("Cannot connect the database!", e);
            }
    }
/*
    public static void close_connection(Connection con){
        con.close();
    }*/

    public static Connection connect_to_database(String url, String username,String password){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
