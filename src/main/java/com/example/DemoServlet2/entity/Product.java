package com.example.DemoServlet2.entity;

import com.example.DemoServlet2.annocation.Column;
import com.example.DemoServlet2.annocation.Table;
import com.example.DemoServlet2.util.ValidateUtil;

import java.util.HashMap;
import java.util.Objects;

@Table(name = "products")
public class Product {
    @Column(name = "id",type = "INT PRIMARY KEY AUTO_INCREMENT")
    private int id;

    @Column(name = "name",type = "VARCHAR(255)")
    private String name;

    @Column(name = "thumbnail",type = "TEXT")
    private String thumbnail;

    @Column(name = "price",type = "DOUBLE")
    private Double price;

    @Column(name = "status",type = "INT")
    private int status;

    public Product() {
    }
    private HashMap<String, String> error;

    public void checkValid(){
        this.error = new HashMap<>();
        if (this.name == null || this.name.length() == 0){
            this.error.put("name","Name tis required!");
        }
        if (this.thumbnail == null || this.thumbnail.length() == 0){
            this.error.put("thumbnail","Thumbnail tis required!");
        }
//        if (!ValidateUtil.checkEmail(this.thumbnail)){
//            this.error.put("thumbnail","Thumbnail tis required!");
//        }
        if (this.price == 0){
            this.error.put("price","Name tis required!");
        }
    }
    public HashMap<String, String> getErrors(){
        checkValid();
        return error;
    }
    public boolean isValid(){
        checkValid();
        return error == null || error.size() == 0;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Product(int id, String name, String thumbnail, Double price, int status) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.status = status;
    }

    public Product(String name, String thumbnail, Double price) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
