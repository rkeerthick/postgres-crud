package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect(String dbname, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname, user, password);
            if(conn != null) System.out.println("connected");
            else System.out.println("Not connected");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void createTable(Connection conn, String table_name) {
        Statement st;
        try {
            String query = "create table "+table_name+"(id int, name varchar(200), email varchar(200), primary key(id));";
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("Table Created");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn, String table_name, int sid, String name, String email) {
        Statement st;
        try {
            String query = String.format("insert into %s values(%d, '%s', '%s');", table_name, sid, name, email);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
