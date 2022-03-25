package com.example.DemoServlet2.controller.product;

import com.example.DemoServlet2.entity.Product;
import com.example.DemoServlet2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailProductServlet extends HttpServlet {
    private ProductModel model = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product obj = model.findById(id);
        if (obj == null){
            resp.setStatus(404);
           resp.getWriter().println("Not found");

        }else {
            req.setAttribute("obj",obj);
            req.getRequestDispatcher("/admin/products/DetailProduct.jsp").forward(req, resp);
        }
    }
}
