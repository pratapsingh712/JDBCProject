import org.postgresql.Driver;

import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException { // can also just give throws Exception that will be able to handle any Exception

        /*
        import package
        load driver
        register driver
        create connection
        create statement
        execute statement
        close connection
         */

        String url = "jdbc:postgresql://localhost:5432/Demo"; // if you want to connect on network local host change with ip address
        String uname = "postgres";
        String pass = "Raghav@1234";

        String query = "select sname from student where sid = 1;";

        //Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);

        System.out.println("connection established !");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query);

        //System.out.println(rs.next()); // return true is you have next row else return false;

//        rs.next();
//
//        String name = rs.getString("sname"); // I am specifying which column I want to display
//
//        System.out.println("Name of a student is "+name);

        con.close();

        System.out.println("Connection closed!");

    }
}
