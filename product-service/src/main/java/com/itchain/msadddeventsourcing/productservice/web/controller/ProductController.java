package com.itchain.msadddeventsourcing.productservice.web.controller;

import com.itchain.msadddeventsourcing.productservice.application.ProductApplicationServiceImpl;
import com.itchain.msadddeventsourcing.productservice.application.ProductQueryService;
import com.itchain.msadddeventsourcing.productservice.domain.Product;
import com.itchain.msadddeventsourcing.productservice.domain.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductApplicationServiceImpl productApplicationService;

    @Autowired
    ProductQueryService productQueryService;

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.POST)
    public void addProduct(@PathVariable String productId, @RequestBody ProductDTO productDTO) {
        productApplicationService.addProduct(productId, productDTO.getProductName(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getSales());
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String productId) {
        productApplicationService.deleteProduct(productId);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PATCH)
    public void updateProduct(@PathVariable String productId, @RequestBody ProductDTO productDTO) {
        productApplicationService.updateProduct(productId, productDTㅔO.getProductName(), productDTO.getDescription(), productDTO.getPrice());
    }

    @RequestMapping(value = "/products/stocks-sales/{productId}", method = RequestMethod.PATCH)
    public void soldProduct(@PathVariable String productId, @RequestBody int soldNum) {
        productApplicationService.soldProduct(productId, soldNum);
    }

    @RequestMapping(value = "/products/stock/{productId}/", method = RequestMethod.PATCH)
    public void addStock(@PathVariable String productId, @RequestBody int additionalStockNum) {
        productApplicationService.addProductStock(productId, additionalStockNum);
    }

    @RequestMapping(value = "/products/bests/", method = RequestMethod.GET)
    public List<ProductDTO> getBestProducts(@RequestBody int num) {
        return productQueryService.getBestProducts(num);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProductList() {
        return productQueryService.getProductList();
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductList(@PathVariable String productId) {
        return productQueryService.getProductById(productId);
    }

}