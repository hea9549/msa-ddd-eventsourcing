package com.itchain.msadddeventsourcing.productservice.port.adapter.persistence;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class ProductProjectionRepository {

    private List<Product> productList;

    public ProductProjectionRepository() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (this.productList.stream().filter(product1 -> product1.getID().equals(product.getID())).findAny().orElse(null) == null){
            this.productList.add(product);
        }
    }

    public void deleteProduct(String productId) {
        this.productList.removeIf(product -> product.getID().equals(productId));
    }

    public void updateProduct(String productId, String productName, String description, int price) {
        Product objProduct = getProductById(productId);
        Product newProduct = new Product(productId, productName, description, price, objProduct.getStock(), objProduct.getSales());
        this.productList.removeIf(product -> product.getID().equals(productId));
        this.productList.add(newProduct);
    }

    public void changeProductStock(String productId, int stock){
        Product objProduct = getProductById(productId);
        Product newProduct = new Product(productId, objProduct.getProductName(), objProduct.getDescription(), objProduct.getPrice(), stock, objProduct.getSales());
        this.productList.removeIf(product -> product.getID().equals(productId));
        this.productList.add(newProduct);
    }

    public void changeProductSales(String productId, int sales){
        Product objProduct = getProductById(productId);
        Product newProduct = new Product(productId, objProduct.getProductName(), objProduct.getDescription(), objProduct.getPrice(), objProduct.getStock(), sales);
        this.productList.removeIf(product -> product.getID().equals(productId));
        this.productList.add(newProduct);
    }

    public Product getProductById(String productId) {
        return productList.stream().filter(product -> productId.equals(product.getID())).findAny().orElse(null);
    }

}
