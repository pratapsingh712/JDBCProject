package preparedStatement;

import java.sql.*;

public class PreparedStatements {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:postgresql://localhost:5432/studentManagement";
        String uname = "postgres";
        String pass = "Raghav@1234";

        int sid = 101;
        String sname = "Max";
        int marks = 48;

        String sql = "insert into student values(" +sid +", '" +sname +"', "+marks+ ")"; // can lead to sql injection and this way of inserting is very confusing
        // we need to keep in mind that we should also think about performance optimisation and it can be achieved with the help of caching the query -> prepared statement

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established!");

        Statement st = con.createStatement();

        st.execute(sql);

        con.close();

        System.out.println("Connection closed!");

    }
}
