package crud;

import java.sql.*;

public class StudentManagementSystem {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/studentManagement";
        String uname = "postgres";
        String pass = "Raghav@1234";
        String insertQuery = "INSERT INTO Students (StudentID, FirstName, LastName, Age)\n" +
                "VALUES (1, 'John', 'Doe', 20);";

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established!");

        Statement st = con.createStatement();

        //boolean data_Inserted = st.execute("insert into student values(1,'Raghav',100);");

       // System.out.println("Data Inserted:"+data_Inserted);

        ResultSet rs = st.executeQuery("select * from student");

        while(rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3) + " - ");
        }
        con.close();

        System.out.println("connection closed :");
    }
}
