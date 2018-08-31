package com.itchain.msadddeventsourcing.productservice.application;

import com.itchain.msadddeventsourcing.productservice.domain.Product;
import com.itchain.msadddeventsourcing.productservice.port.adapter.persistence.ProductProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductQueryServiceImpl implements ProductQueryService{

    @Autowired
    private ProductProjectionRepository productProjectionRepository;

    public List<Product> getBestProducts(int num, int index) {
        // index 는 페이지 index 1부터 시작한다고 가정
        List<Product> productList = productProjectionRepository.getProductList();
        productList.sort(Comparator.comparingInt(Product::getSales));

        if (productList.size() > index * num){
            return productList.subList((index - 1) * num , index * num - 1);
        }

        return productList.subList((index - 1) * num, productList.size());
    }

    public List<Product> getProductsSortByProductName(int num, int index){

        List<Product> productList = productProjectionRepository.getProductList();
        productList.sort(Comparator.comparing(Product::getProductName));

        if (productList.size() > index * num){
            return productList.subList((index - 1) * num , index * num - 1);
        }

        return productList.subList((index - 1) * num, productList.size());
    }

    @Override
    public List<Product> getProductList() {
        return this.productProjectionRepository.getProductList();
    }

    @Override
    public Product getProductById(String productId){
        return this.productProjectionRepository.getProductById(productId);
    }
}
