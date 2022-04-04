package com.example.DemoServlet2.entity;

public class CartItem {
    private int productId; // co the moc vao database lay het thong tin name, thumbnail
    private String productName; // han che truy van database
    private String productThumbnail; // han che truy van database
    private int quantity;
    private double unitPrice; // Gia tai thoi diem mua

    public CartItem() {
    }

    public CartItem(int productId, String productName, String productThumbnail, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productThumbnail = productThumbnail;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productThumbnail='" + productThumbnail + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductThumbnail() {
        return productThumbnail;
    }

    public void setProductThumbnail(String productThumbnail) {
        this.productThumbnail = productThumbnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
