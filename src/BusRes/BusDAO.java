package BusRes;

import java.sql.*;

public class BusDAO {
    public void displayBusInfo() throws SQLException
    {
        String Query = "SELECT * FROM Bus";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(Query);

        while (rs.next())
        {
            System.out.println("Bus No : "+rs.getInt(1));
            if(rs.getInt(2) == 0)
            {
                System.out.println("AC : no");
            }
            else
            {
                System.out.println("AC : yes");
            }
            System.out.println("Capacity : "+rs.getInt(3));

            System.out.println();
        }
        System.out.println("--------------------------------------");

    }

    public int getCapacity(int busId) throws SQLException
    {
        String Query = "SELECT capacity from Bus WHERE busId =" + busId;
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(Query);

        rs.next();
        return rs.getInt(1);
    }
}
