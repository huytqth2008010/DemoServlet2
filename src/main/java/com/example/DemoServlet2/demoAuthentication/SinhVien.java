package com.example.DemoServlet2.demoAuthentication;

public class SinhVien extends ConNguoi implements AuthenticationService{
    @Override
    public void thichLamGiDo() {
        System.out.println("Thích chơi game");
        System.out.println("Thích ngủ nướng");
        System.out.println("Thích lên thư viện để ngắm gái.");
    }

    @Override
    public Account register(Account account) {
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
