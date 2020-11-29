package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost/CAP_DB";
            String username = "dbi";
            String password = "dbi_pass";
            Connection con = get_sql_con(url,username,password);
    }

    public static Connection get_sql_con(String url, String username,String password){
        System.out.println("Connecting database...");
        try  {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}
