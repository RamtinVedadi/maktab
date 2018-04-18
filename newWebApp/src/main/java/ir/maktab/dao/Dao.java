package ir.maktab.dao;

import ir.maktab.entities.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Dao {

    protected Connection connection;
    protected PreparedStatement ps;

    {
        String username = "root";
        String pass = "";
        try {
            String url = String.format("jdbc:mysql://localhost/professorstudent?user=%s&password=%s", username, pass);
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract Boolean add(Student student) throws Exception;

    public abstract Student[] list() throws Exception;

    public abstract Boolean delete(Integer ID) throws Exception;

    public abstract Boolean update(Student student) throws Exception;
}
