import com.company.DbFunctions;

import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect("registration-db", "postgres", "root");
//        db.createTable(conn, "student");
//        db.insert_row(conn, "student", 101, "aaa", "a@mail.com");
        db.display(conn, "student");
    }
}