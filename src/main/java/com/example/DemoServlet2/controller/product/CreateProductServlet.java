package com.example.DemoServlet2.controller.product;

import com.example.DemoServlet2.entity.Product;
import com.example.DemoServlet2.entity.Student;
import com.example.DemoServlet2.model.ProductModel;
import com.example.DemoServlet2.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/products/CreateProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        int price = Integer.parseInt(req.getParameter("price"));
        Product obj = new Product(name, thumbnail, price);
        ProductModel model = new ProductModel();
        model.save(obj);
        resp.sendRedirect("/products/list");
    }
}
