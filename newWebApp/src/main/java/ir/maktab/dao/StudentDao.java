package ir.maktab.dao;

import ir.maktab.entities.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends Dao {
    private static StudentDao instance = new StudentDao();

    public static StudentDao getInstance() {
        return instance;
    }

    public StudentDao() {
        super();
    }

    @Override
    public Boolean add(Student student) throws Exception {
        try {
            Student se = (Student) student;
            String query = "INSERT INTO student (StudentID,name,familyname,faculty) VALUES (?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, se.getId());
            ps.setString(2, se.getFirstName());
            ps.setString(3, se.getLastName());
            ps.setString(4, se.getFaculty());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public Student[] list() throws Exception {
        try {
            String query = "SELECT * FROM student";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.last();
            int r = rs.getRow();
            rs.beforeFirst();
            int i = 0;
            Student[] se = new Student[r];
            while (rs.next() == true) {
                se[i] = new Student();
                se[i].setId(rs.getInt(1));
                se[i].setFirstName(rs.getString(2));
                se[i].setLastName(rs.getString(3));
                se[i].setFaculty(rs.getString(4));
                i++;
            }
            return se;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Boolean delete(Integer ID) throws Exception {
        try {
            String query = "DELETE FROM student WHERE StudentID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean update(Student student) throws Exception {
        try {
            Student me = (Student) student;
            String query = "UPDATE student SET name=? , familyname=?, faculty=? where StudentID=?";
            ps = connection.prepareStatement(query);
            ps.setString(1, me.getFirstName());
            ps.setString(2, me.getLastName());
            ps.setString(3, me.getFaculty());
            ps.setInt(4, me.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
