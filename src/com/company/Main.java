package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost/CAP_DB";
            String username = "dbi";
            String password = "dbi_pass";
            String query = "SELECT * FROM agents";
            ResultSet result = make_sql_request(url,username,password,query);
    }

    public static ResultSet make_sql_request(String url, String username,String password,String query){
        System.out.println("Connecting database...");
        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            Statement st = connection.createStatement();
            ResultSet my_result = st.executeQuery(query);
            connection.close();
            return my_result;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}
