package com.itchain.samplemsa.samplemsa.product.web.controller;

import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import com.itchain.samplemsa.samplemsa.product.application.ProductApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//RestController랑 Controller 차이 자동을 xml, json해주는거
//3 layers service,
@RestController
public class ProductController {

    @Autowired
    ProductApplicationServiceImpl productApplicationService;

    @RequestMapping(value = "/product/addProduct/{productId}/{productName}/{description}/{price}/{stock}", method = RequestMethod.PUT)
    public void addProduct(@PathVariable String productId, @PathVariable String productName,
                           @PathVariable String description, @PathVariable int price, @PathVariable int stock) {
        productApplicationService.addProduct(productId, productName, description, price, stock);
    }

    @RequestMapping(value = "/product/deleteProduct/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String productId) {
        productApplicationService.deleteProduct(productId);
    }

    @RequestMapping(value = "/product/soldProduct/{productId}/{soldNum}", method = RequestMethod.POST)
    public void soldProduct(@PathVariable String productId, @PathVariable int soldNum) {
        productApplicationService.soldProduct(productId, soldNum);
    }

    @RequestMapping(value = "/product/updateProduct/{productId}/{productName}/{description}/{price}", method = RequestMethod.POST)
    public void updateProduct(@PathVariable String productId, @PathVariable String productName,
                              @PathVariable String description, @PathVariable int price) {
        productApplicationService.updateProduct(productId, productName, description, price);

    }

    @RequestMapping(value = "/product/addStock/{productId}/{additionalStockNum}", method = RequestMethod.POST)
    public void addStock(@PathVariable String productId,@PathVariable int additionalStockNum) {
        productApplicationService.addProductStock(productId, additionalStockNum);
    }

    @RequestMapping(value = "/product/getBestProduct/{num}", method = RequestMethod.GET)
    public List<ProductDTO> getBestProduct(@PathVariable int num) {
        return productApplicationService.getBestProduct(num);
    }

    @RequestMapping(value = "/product/getProductSortByProductName/{num}", method = RequestMethod.GET)
    public List<ProductDTO> getProductSortByProductName(@PathVariable int num){
        return productApplicationService.getProductSortByProductName(num);
    }

}