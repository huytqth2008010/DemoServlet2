package com.example.DemoServlet2.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ShoppingCartFactory {
    private static final String SHOPPING_CART_NAME = "shoppingCart";

    //Xử lý lấy xe hàng từ session
    public static ShoppingCart getShoppingCartFromSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(SHOPPING_CART_NAME);
        //Không có xe
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        return  shoppingCart;
    }
// Đưa xe hàng trở lại session
    public static  void setShoppingCartToSession(HttpServletRequest request, ShoppingCart shoppingCart){
        HttpSession session = request.getSession();
        session.setAttribute(SHOPPING_CART_NAME, shoppingCart);
    }
}
