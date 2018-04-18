package ir.maktab.servlets;

import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentDelete")
public class StudentDelete extends javax.servlet.http.HttpServlet {
    public StudentDelete() {
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
        student.setId(id);
        try {
            studentManager.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("index.jsp");
        }
    }
}
