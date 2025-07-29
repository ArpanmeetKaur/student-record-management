package src;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("add".equals(action)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");
            String age = request.getParameter("age");

            Student student = new Student(id, name, email, course, age);
            StudentManager.addStudent(student);
        } else if ("delete".equals(action)) {
            String delId = request.getParameter("id");
            StudentManager.deleteStudent(delId);
        }

        // back to the form page to refresh records
        response.sendRedirect("students");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    List<Student> students = StudentManager.getAllStudents();

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Student Record Management System</title>");
    out.println("<link rel='stylesheet' href='style.css'>");
    out.println("<style>");
    out.println("body { font-family: Arial; background: #f5f5f5; padding: 20px; }");
    out.println(".container { background: #fff; padding: 20px; border-radius: 10px; max-width: 800px; margin: auto; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
    out.println("h1, h2 { text-align: center; color: #333; }");
    out.println(".form-group { margin-bottom: 10px; }");
    out.println("label { display: block; font-weight: bold; }");
    out.println("input { padding: 8px; width: 100%; box-sizing: border-box; }");
    out.println("button { padding: 10px 20px; background: #4CAF50; color: white; border: none; cursor: pointer; }");
    out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
    out.println("th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }");
    out.println("th { background-color: #f0f0f0; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");

    out.println("<h1>Student Record Management System</h1>");

    // Add Student Form
    out.println("<h2>Add New Student</h2>");
    out.println("<form action='students' method='post'>");
    out.println("<input type='hidden' name='action' value='add'>");

    out.println("<div class='form-group'><label for='id'>Student ID:</label><input type='number' id='id' name='id' required></div>");
    out.println("<div class='form-group'><label for='name'>Name:</label><input type='text' id='name' name='name' required></div>");
    out.println("<div class='form-group'><label for='email'>Email:</label><input type='email' id='email' name='email' required></div>");
    out.println("<div class='form-group'><label for='course'>Course:</label><input type='text' id='course' name='course' required></div>");
    out.println("<div class='form-group'><label for='age'>Age:</label><input type='number' id='age' name='age' required></div>");

    out.println("<button type='submit'>Add Student</button>");
    out.println("</form>");

    // Display Records
    out.println("<h2>Student Records</h2>");
    out.println("<table>");
    out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Age</th><th>Actions</th></tr>");
  
    for (Student s : students) {
        out.println("<tr>");
        out.println("<td>" + s.getId() + "</td>");
        out.println("<td>" + s.getName() + "</td>");
        out.println("<td>" + s.getEmail() + "</td>");
        out.println("<td>" + s.getCourse() + "</td>");
        out.println("<td>" + s.getAge() + "</td>");
        out.println("<td>");
        out.println("<form action='students' method='post' style='display:inline;'>");
        out.println("<input type='hidden' name='action' value='delete'>");
        out.println("<input type='hidden' name='id' value='" + s.getId() + "'>");
        out.println("<button type='submit'>Delete</button>");
        out.println("</form>");
        out.println("</td>");
        out.println("</tr>");
    }       


    out.println("</table></div></body></html>");
    }
}       
