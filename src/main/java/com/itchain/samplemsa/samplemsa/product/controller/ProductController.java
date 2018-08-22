package com.itchain.samplemsa.samplemsa.product.controller;

import com.itchain.samplemsa.samplemsa.product.domain.ProductDTO;
import com.itchain.samplemsa.samplemsa.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//RestController랑 Controller 차이 자동을 xml, json해주는거
//3 layers service,
@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping(value = "/product/{productId}/{productName}/{description}/{price}/{stock}/{sales}/add_product", method = RequestMethod.PUT)
    public void addProduct(@PathVariable String productId, String productName, String description, int price, int stock, int sales) {
        productService.addProduct(productId, productName, description, price, stock, sales);
    }

    @RequestMapping(value = "/product/{productId}/delete_product", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }

    @RequestMapping(value = "/product/{productId}/{num}/sold_product", method = RequestMethod.POST)
    public void soldProduct(String productId, int soldNum) {
        productService.soldProduct(productId, soldNum);
    }

    @RequestMapping(value = "{num}/best_product", method = RequestMethod.POST)
    public List<ProductDTO> getBestProduct(int num) {
        return productService.getBestProduct(num);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<ProductDTO> getCategoryProduct(String category) {
        //List<ProductDTO> productList = productService.getProductsByCategory(category);
        List<ProductDTO> productList = new ArrayList<>();
        return productList;
    }


}