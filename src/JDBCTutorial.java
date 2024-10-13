import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
public class JDBCTutorial {
    public static void main(String[] args)throws Exception{
        storedproc();
        //we use callable statement to call stored procedure
    }
    public static void readRecords() throws Exception
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";
        Connection con = DriverManager.getConnection(url,userName,passWord);
        String query = "SELECT * FROM employee";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query); //only for select or read

        while(rs.next())
        {
            System.out.println("Id is " + rs.getInt(1));
            System.out.println("salary is " + rs.getInt(2));
            System.out.println("Name is " + rs.getString(3));
            System.out.println();
        }
        con.close();
    }

    public static void insertRecords() throws Exception
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";
        Connection con = DriverManager.getConnection(url,userName,passWord);
        String query = "INSERT INTO employee VALUES(4,43000,\"Pari\")";
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query); //it is for insert records and it returns integer

        System.out.println("Number of rows affected:" + rows);
        con.close();
    }

    public static void insertRecordsByVar() throws Exception
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";
        Connection con = DriverManager.getConnection(url,userName,passWord);
        int id = 5;
        int salary = 25000;
        String name = "Kumar";

        String query = "INSERT INTO employee VALUES(" + id + ","+salary + ",'"+name + "');";
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query); //it is for insert records and it returns integer

        System.out.println("Number of rows affected:" + rows);
        con.close();
    }

    public static void insertUsingPST() throws Exception //Insert using Prepared Statement
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";
        int id = 6;
        int salary = 35000;
        String name = "Muthu";

        String query = "INSERT INTO employee VALUES(?,?,?)";

        Connection con = DriverManager.getConnection(url,userName,passWord);

        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,id);
        pst.setInt(2,salary);
        pst.setString(3,name);
        int rows = pst.executeUpdate();

        System.out.println("Number of rows affected:" + rows);
        con.close();
    }

    public static void delete() throws Exception //Insert using Prepared Statement
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";

        String query = "DELETE from employee WHERE id = 5";

        Connection con = DriverManager.getConnection(url,userName,passWord);

        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);
        System.out.println("Number of rows affected:" + rows);
        con.close();
    }

    public static void update() throws Exception //Insert using Prepared Statement
    {
        String userName = "root";
        String passWord = "pwd_for_SQL";
        String url = "jdbc:mysql://localhost:3306/jdbcTutorial";

        String query = "UPDATE employee SET salary = 15000 WHERE id = 4";

        Connection con = DriverManager.getConnection(url,userName,passWord);

        Statement st = con.createStatement();
        int rows = st.executeUpdate(query);

        System.out.println("Number of rows affected:" + rows);
        con.close();
    }

    public static void storedproc() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String userName = "root";
        String passWord = "pwd_for_SQL";

        Connection con = DriverManager.getConnection(url,userName,passWord);
        CallableStatement  cst = con.prepareCall("{call getEmp()}");
        ResultSet rs = cst.executeQuery(); //in stored procedure we do read ,thats why we use executeQuery
        while(rs.next())
        {
            System.out.println("Id is " + rs.getInt(1));
            System.out.println("salary is " + rs.getInt(2));
            System.out.println("Name is " + rs.getString(3));
            System.out.println();
        }
       con.close();
    }
}

