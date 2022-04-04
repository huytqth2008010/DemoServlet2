package com.example.DemoServlet2.controller.shoppingcart;

import com.example.DemoServlet2.entity.ShoppingCart;
import com.example.DemoServlet2.entity.ShoppingCartFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowShoppingCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = ShoppingCartFactory.getShoppingCartFromSession(req);
        req.setAttribute("shoppingCart", shoppingCart);
        req.getRequestDispatcher("/admin/carts/show.jsp").forward(req, resp);
    }
}
