package com.example.DemoServlet2.demoAuthentication;

public class FacebookAuthenticationService implements AuthenticationService{
    @Override
    public Account register(Account account) {
        System.out.println("Facebook");
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
