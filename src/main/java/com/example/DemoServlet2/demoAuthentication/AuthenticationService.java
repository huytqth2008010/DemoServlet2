package com.example.DemoServlet2.demoAuthentication;

/**
 * Xử lý các thao tác liên quan đến đăng ký, đăng nhập,
 * đăng xuất và sửa thông tin người dùng. Sau này sẽ có nhiều thể hiện khác nhau.
 * */

public interface AuthenticationService {
    // Account trả về phải có trường id.
    Account register(Account account);
    // Nhận thông tin vào là username, password, check thông tin này nếu tồn tại trả về true.
    boolean login(String username, String password);
    // Clear session người dùng.
    boolean logout();
    // Kiểm tra xem tồn tại username đó không, nếu có gửi email cho nó.
    boolean forgetPassword(String username);
    // Kiểm tra token khi người dùng click vào link trong email. Tiến hành đổi mật khẩu nếu token đúng.
    boolean handleForgetPassword(String token);
}
