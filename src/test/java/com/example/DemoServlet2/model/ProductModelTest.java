package com.example.DemoServlet2.model;

import com.example.DemoServlet2.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductModelTest {

    @Test
    void save() {
        ProductModel model = new ProductModel();
        model.save(new Product("a","a",4.0));
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        ProductModel model = new ProductModel();
        Product product = model.findById(3);
        System.out.println(product.toString());
    }

    @Test
    void update() {
        ProductModel model = new ProductModel();
        Product product = model.findById(3);
        System.out.println(product.toString());
        product.setName("Meo 22");
        model.update(3,product);
    }

    @Test
    void delete() {
        ProductModel model = new ProductModel();
        model.delete(4);
    }

    @Test
    void testSave() {
        ProductModel model = new ProductModel();
        model.save(new Product("a","a",4.0));
    }

    @Test
    void testSave1() {
        ProductModel model = new ProductModel();
        model.save(new Product("a1","a", 4.0));
    }

    @Test
    void testFindAll() {
    }

    @Test
    void testFindById() {
        ProductModel model = new ProductModel();
        Product product = model.findById(17);
        System.out.println(product.toString());
    }

    @Test
    void testUpdate() {
        ProductModel model = new ProductModel();
        Product product = model.findById(18);
        System.out.println(product.toString());
        product.setName("Update");
        model.update(18,product);
    }

    @Test
    void testDelete() {
        ProductModel model = new ProductModel();
        model.delete(17);
    }
}