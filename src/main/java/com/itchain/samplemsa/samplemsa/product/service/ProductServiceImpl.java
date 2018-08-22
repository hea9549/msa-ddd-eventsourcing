package com.itchain.samplemsa.samplemsa.product.service;

import com.itchain.samplemsa.samplemsa.common.AggregateRepository;
import com.itchain.samplemsa.samplemsa.common.EventRepository;
import com.itchain.samplemsa.samplemsa.product.ProductRepository;
import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    //TODO Api-gateway를 가지고있지 않고 URL로 ...
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProductsByCategory(String category) {
        //TODO Api-gateway를 통해 category에 맞는 리스트를 받아옴
        //Product를 ProductDTO에 맞게 변형

        return null;
    }

    //TODO 만들기 위한 재료가 와야함.
    public void addProduct(String productId, String productName,
                           String description, int price, int stock) {
        Product product = new Product(productId, productName, description, price, stock, 0);
        productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        // API-Gateway에서 product를 가져와야함
        Product product = productRepository.findById(productId);
        product.delete();
        productRepository.save(product);
    }

    public void soldProduct(String productId, int num) {
        //TODO 고치기
        Product product = productRepository.findById(productId);
        product.sold(num);
        productRepository.save(product);
    }

    public void updateProduct(String productId, String productName, String description, int price, int stock) {
        Product product = productRepository.findById(productId);
        product.update(productId, productName, description, price, stock);
        productRepository.save(product);
    }

    public List<ProductDTO> getBestProduct(int num) {
        //TODO APi-gateway를 통해 sales가 가장 우수한 product들을 num 개수많큼 받아옴
        return null;
    }

    public List<ProductDTO> getProductsSortByPrice() {
        return null;
    }


}
