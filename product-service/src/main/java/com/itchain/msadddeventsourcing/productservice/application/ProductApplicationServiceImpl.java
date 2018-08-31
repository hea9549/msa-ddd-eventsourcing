package com.itchain.msadddeventsourcing.productservice.application;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import com.itchain.msadddeventsourcing.productservice.port.adapter.persistence.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String productId, String productName, String description, int price, int stock) {
        Product product = new Product(productId, productName, description, price, stock, 0);
        productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        Product product = productRepository.findById(productId);
        product.deleteProduct();

        productRepository.save(product);
    }

    public void soldProduct(String productId, int num) {
        Product product = productRepository.findById(productId);
        product.soldProduct(num);

        productRepository.save(product);
    }

    public void updateProduct(String productId, String productName, String description, int price) {
        Product product = productRepository.findById(productId);
        product.updateProduct(productName, description, price);

        productRepository.save(product);
    }

    public void addProductStock(String productId, int additionalStockNum) {
        Product product = productRepository.findById(productId);
        product.addProductStock(additionalStockNum);

        productRepository.save(product);
    }
}
