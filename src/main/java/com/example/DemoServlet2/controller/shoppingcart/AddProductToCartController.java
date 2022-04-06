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

public class AddProductToCartController extends HttpServlet {

    private ProductModel productModel;
    public AddProductToCartController(){
        productModel = new ProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ------------Validate du lieu ----------------
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(req.getParameter("productId"));
            quantity = Integer.parseInt(req.getParameter("quantity"));
        }catch (Exception e){

        }
        if (productId <= 0 || quantity <= 0){
            resp.getWriter().println("Invalid quantity or product id.");
            return;
        }

        // kiem tra san pham co trong database va du hang khong
        Product product = productModel.findById(productId);
        if (product == null){ // check du hang neu can thiet
            resp.getWriter().write("Product is not found!");
            return;
        }
        // ------------Ket thuc validate du lieu ----------------

        ShoppingCart shoppingCart = ShoppingCartFactory.getShoppingCartFromSession(req);
        shoppingCart.addItemToCart(product, quantity);
        ShoppingCartFactory.setShoppingCartToSession(req, shoppingCart);
        req.getSession().setAttribute("message",  "Action session");
        resp.sendRedirect("/shopping-cart/show");

    }


}
