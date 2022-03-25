package com.example.DemoServlet2.controller;

import com.example.DemoServlet2.entity.Student;
import com.example.DemoServlet2.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/student/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String rollNumber = req.getParameter("rollNumber");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        Student student = new Student(id, rollNumber, name, email);
        StudentModel studentModel = new StudentModel();
        studentModel.save(student);
        resp.sendRedirect("/student/list");
    }
}
