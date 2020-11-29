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
        System.out.print("Geben Sie eine Produk ID ein:");
        Scanner scanner = new Scanner(System.in);
        String product_id = scanner.nextLine();
        String query = "SELECT aname as 'Agent', orders.aid as 'Agentennummer',Sum(dollars) AS 'Umsatzzahlen'\n" +
                "From CAP_DB.orders JOIN CAP_DB.agents\n" +
                "    on orders.aid = agents.aid\n" +
                "Where orders.pid='p01'\n" +
                "GROUP BY(orders.aid)\n" +
                "Order by Umsatzzahlen desc";
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
