package com.example.DemoServlet2.demoAuthentication;

public class DatabaseAuthenticationService implements AuthenticationService{
    @Override
    public Account register(Account account) {
        // kết nối db,
        // chạy câu lệnh insert.
        System.out.println("Truyền thống");
        return null;
    }

    @Override
    public boolean login(String username, String password) {
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
