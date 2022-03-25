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
import java.util.List;

public class GetListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = new ProductModel();
        List<Product> listObj = model.findAll();
        req.setAttribute("listObj",listObj);
        req.getRequestDispatcher("/admin/products/ListProduct.jsp").forward(req,resp);
    }
}
