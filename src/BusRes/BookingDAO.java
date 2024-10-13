package BusRes;

import java.sql.*;
import java.sql.SQLException;
import java.util.Date;
public class BookingDAO {
    public int getBookedCount(int busNo,Date date) throws SQLException
    {
        String Query = "SELECT COUNT(passengerName) FROM Booking WHERE busNo = ? AND travelDate = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(Query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        pst.setInt(1,busNo);
        pst.setDate(2,sqlDate);

        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException
    {
        String Query = "INSERT INTO Booking VALUES(?,?,?)";
        Connection con = DBConnection.getConnection();
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(Query);
        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqlDate);

        pst.executeUpdate();

    }
}
