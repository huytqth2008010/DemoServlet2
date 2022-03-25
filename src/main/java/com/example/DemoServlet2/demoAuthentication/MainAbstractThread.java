package com.example.DemoServlet2.demoAuthentication;

public class MainAbstractThread {
    public static void main(String[] args) {
        ConNguoi conSinhVien = new SinhVien();
        ConNguoi conNhanVien = new NhanVien();
        conSinhVien.thichLamGiDo();
        conNhanVien.thichLamGiDo();
        conSinhVien.an();
        conSinhVien.ngu();
    }
}
