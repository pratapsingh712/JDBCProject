package crud;

import java.sql.*;

public class StudentManagementSystem {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/studentManagement";
        String uname = "postgres";
        String pass = "Raghav@1234";
        String insertQuery = "INSERT INTO Student (sid, sname, marks)\n" +
                "VALUES (2, 'John', 65);";

        String update = "update student set sname = 'max' where sid = 2";

        String delete = "delete from student where sid = 2";

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established!");

        Statement st = con.createStatement();

        //boolean data_Inserted = st.execute(insertQuery); //

        //System.out.println("Data Inserted:"+data_Inserted);

        ResultSet rs = st.executeQuery("select * from student");

        while(rs.next()) {
            System.out.print(rs.getInt(1) + " - ");
            System.out.print(rs.getString(2) + " - ");
            System.out.println(rs.getInt(3));
        }

        System.out.println("--------------------------------------------------------------------");

        System.out.println("Let's update the name of id = 2:");
        System.out.println("after updating :");

        st.execute(update);

        ResultSet rs1 = st.executeQuery("select * from student");

        while(rs1.next()){
            System.out.print(rs1.getInt(1) + " - ");
            System.out.print(rs1.getString(2) + " - ");
            System.out.println(rs1.getInt(3));
        }

        System.out.println("--------------------------------------------------------------------");

        System.out.println("let's delete the max row :");
        System.out.println("After deleting the max row :");

        st.execute(delete);

        ResultSet deleted = st.executeQuery("select * from student");

        while(deleted.next()){
            System.out.print(deleted.getInt(1) + " - ");
            System.out.print(deleted.getString(2) + " - ");
            System.out.println(deleted.getInt(3));
        }

        con.close();

        System.out.println("connection closed :");
    }
}
