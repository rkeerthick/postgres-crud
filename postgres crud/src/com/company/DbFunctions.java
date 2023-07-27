package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    public void insert_row(Connection conn, int sid, String name, String email) {
        Statement st;
        try {
            String query = String.format("insert into student values(%d, '%s', '%s');", sid, name, email);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("inserted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_row_by_name(Connection conn, int sid, String name) {
        Statement st ;
        try {
            String query = String.format("update student set name = '%s' where id = %d", name, sid);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("name updated");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_row_by_email(Connection conn, int sid, String email) {
        Statement st ;
        try {
            String query = String.format("update student set email = '%s' where id = %d", email, sid);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("email updated");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_row(Connection conn, int sid, String name, String email) {
        Statement st ;
        try {
            String query = String.format("update student set name = '%s' and email = '%s' where id = %d", name, email, sid);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("name and email are updated");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Connection conn, int sid) {
        Statement st ;
        try {
            String query = String.format("delete from student where id = %d", sid);
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("deleted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void display(Connection conn ){
        Statement st;
        ResultSet rs = null;
        try {
            String query = String.format("select * from student;");
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()) {
                System.out.println("ID\tName\tE\tmail\t\t");
                System.out.print(rs.getInt("id") + "\t");
                System.out.println(rs.getString("name") + "\t");
                System.out.println(rs.getString("email") + "\t");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
