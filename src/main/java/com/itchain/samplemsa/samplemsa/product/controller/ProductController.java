package com.itchain.samplemsa.samplemsa.product.controller;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import com.itchain.samplemsa.samplemsa.product.service.ProductApplicationServiceImpl;
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
    ProductApplicationServiceImpl productService;

    @RequestMapping(value = "/product/addProduct/{productId}/{productName}/{description}/{price}/{stock}", method = RequestMethod.PUT)
    public void addProduct(@PathVariable String productId, @PathVariable String productName,
                           @PathVariable String description, @PathVariable int price, @PathVariable int stock) {
        productService.addProduct(productId, productName, description, price, stock);
    }

    @RequestMapping(value = "/product/deleteProduct/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
    }

    @RequestMapping(value = "/product/soldProduct/{productId}/{soldNum}", method = RequestMethod.POST)
    public void soldProduct(@PathVariable String productId, @PathVariable int soldNum) {
        productService.soldProduct(productId, soldNum);
    }

    @RequestMapping(value = "/product/updateProduct/{productId}/{productName}/{description}/{price}", method = RequestMethod.POST)
    public void updateProduct(@PathVariable String productId, @PathVariable String productName,
                              @PathVariable String description, @PathVariable int price) {
        productService.updateProduct(productId, productName, description, price);

    }

    @RequestMapping(value = "/product/addStock/{productId}/{additionalStockNum}", method = RequestMethod.POST)
    public void addStock(@PathVariable String productId,@PathVariable int additionalStockNum) {
        productService.addProductStock(productId, additionalStockNum);
    }

    @RequestMapping(value = "/product/best_product/{num}", method = RequestMethod.GET)
    public List<ProductDTO> getBestProduct(@PathVariable int num) {
        return productService.getBestProduct(num);
    }

    @RequestMapping(value = "/product/getAllProducts", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<ProductDTO> getCategoryProduct(String category) {
        return productService.getProductsByCategory(category);
    }


}