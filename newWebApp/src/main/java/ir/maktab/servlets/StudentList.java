package ir.maktab.servlets;

import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentList")
public class StudentList extends javax.servlet.http.HttpServlet {
    public StudentList() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student[] students = (Student[]) StudentManager.getInstance().list();
            PrintWriter out = response.getWriter();
            for (Student studentEntity : students) {
                out.println(studentEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.sendRedirect("index.jsp");
        }

    }
}
