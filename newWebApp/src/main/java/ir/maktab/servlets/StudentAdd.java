package ir.maktab.servlets;

import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentAdd")
public class StudentAdd extends javax.servlet.http.HttpServlet {
    public StudentAdd() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student student = new Student();
        StudentManager studentManager = StudentManager.getInstance();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String familyname = request.getParameter("familyname");
        String faculty = request.getParameter("faculty");
        student.setId(id);
        student.setFirstName(name);
        student.setLastName(familyname);
        student.setFaculty(faculty);
        try {
            studentManager.add(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("index.jsp");
            response.setStatus(200, "Student Is Added");
        }
    }
}
