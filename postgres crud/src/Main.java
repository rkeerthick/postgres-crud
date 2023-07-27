import com.company.DbFunctions;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DbFunctions db = new DbFunctions();
        Connection conn = db.connect("registration-db", "postgres", "root");
        Scanner sc = new Scanner(System.in);

        Set<Integer> student_id = new HashSet<>();
        char optt;
        do {
            System.out.println("Hello !!!");
            System.out.println("1.Enter user : \n2.update user : \n3.Delete user : \n4.Display table");
            System.out.println("Enter your choice : ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    System.out.println("Enter the id : ");
                    int id = sc.nextInt();
                    System.out.println("Enter the name : ");
                    String name = sc.next();
                    System.out.println("Enter the email id : ");
                    String email = sc.next();
                    if(student_id.contains(id)) {
                        System.out.println("student id already exist...");
                        break;
                    }
                    db.insert_row(conn, id, name, email);
                    break;


                case 2 :
                    System.out.println("Enter the student-id : ");
                    int sid = sc.nextInt();
                    System.out.println("What are you going to edit : \n1.Name\n2.Email\n3.Both");
                    int opt = sc.nextInt();
                    String upd_name = "";
                    String upd_email = "";
                    switch (opt) {
                        case 1:
                            System.out.println("Enter the name : ");
                            upd_name = sc.next();
                            db.update_row_by_name(conn, sid, upd_name);
                            break;
                        case 2 :
                            System.out.println("Enter the email : ");
                            upd_email = sc.next();
                            db.update_row_by_email(conn, sid, upd_email);
                            break;
                        case 3 :

                            System.out.println("Enter the name : ");
                            upd_name = sc.next();
                            System.out.println("Enter the email : ");
                            upd_email = sc.next();
                            db.update_row(conn, sid, upd_name, upd_email);
                            break;
                    }
                    break;

                case 3 :
                    System.out.println("Delete a user using student id : ");
                    int std_id = sc.nextInt();
                    db.delete(conn, std_id);
                    break;

                case 4 :
//                System.out.println("sid      name               email");
                    db.display(conn);
            }
            System.out.println("Do you want to continue(y/n) : ");
            optt = sc.next().charAt(0);
        } while(optt == 'y');


//        db.createTable(conn, "student");
//        db.insert_row(conn, "student", 101, "aaa", "a@mail.com");
//        db.display(conn, "student");
    }
}