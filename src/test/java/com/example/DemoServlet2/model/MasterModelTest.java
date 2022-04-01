package com.example.DemoServlet2.model;

import com.example.DemoServlet2.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MasterModelTest {

    @Test
    void save() {
        MasterModel<Product> productMasterModel = new MasterModel<>();
        productMasterModel.save(new Product("Product 02", "10", 100.1));
    }



}