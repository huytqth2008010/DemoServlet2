package com.example.DemoServlet2.controller.shoppingcart;

import com.example.DemoServlet2.entity.Product;
import com.example.DemoServlet2.entity.ShoppingCart;
import com.example.DemoServlet2.entity.ShoppingCartFactory;
import com.example.DemoServlet2.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProductFromCartController extends HttpServlet {
    private ProductModel productModel;

    public DeleteProductFromCartController() {
        productModel = new ProductModel();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = 0;
        try {
            productId = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            resp.getWriter().println("Invalid parameter.");
            return;
        }
        Product product = productModel.findById(productId);
        if (product == null){
            resp.getWriter().println("Product is not found");
            return;
        }
        ShoppingCart shoppingCart = ShoppingCartFactory.getShoppingCartFromSession(req);
        shoppingCart.removeItemFromCart(product);
        ShoppingCartFactory.setShoppingCartToSession(req, shoppingCart);
        req.getSession().setAttribute("message", "Action success!");
        resp.setStatus(200);
    }
}
