package com.example.DemoServlet2.demoAuthentication;

import java.util.Date;

public abstract class ConNguoi {

    private String cccd;
    private String hoVaTen;
    private Date birthday;
    private String address;

    public abstract void thichLamGiDo();

    public void an() {
        System.out.println("Ăn");
    }

    public void ngu() {
        System.out.println("Đi ngủ");
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
