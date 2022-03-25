package com.example.DemoServlet2.entity;

public class Customer {
    public static void main(String[] args) {
        // StringBuilder vs concat string;
        String name = "Huy";
        name += "Truong";
        System.out.println(name);

        StringBuilder anotherName = new StringBuilder("Huy");
        for (int i = 0; i < 1000; i++) {
            anotherName.append(i);
        }
        System.out.println(anotherName);
    }
}
