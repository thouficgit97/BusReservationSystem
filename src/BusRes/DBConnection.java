package BusRes;
import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/busResv";
    private static final String userName = "root";
    private static final String passWord = "pwd_for_SQL";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,userName,passWord);
    }
}
