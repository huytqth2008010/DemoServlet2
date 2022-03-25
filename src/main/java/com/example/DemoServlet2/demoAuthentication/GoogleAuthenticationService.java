package com.example.DemoServlet2.demoAuthentication;

public class GoogleAuthenticationService implements AuthenticationService{
    @Override
    public Account register(Account account) {
        System.out.println("Google");
        // redirect sang google lấy thông tin account.
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        // click nút đăng nhập bằng google, lấy thông tin theo token
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean forgetPassword(String username) {
        return false;
    }

    @Override
    public boolean handleForgetPassword(String token) {
        return false;
    }
}
