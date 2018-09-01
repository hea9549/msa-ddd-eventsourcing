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

    public List<ProductDTO> getBestProducts(int num) {
        List<Product> productList = productProjectionRepository.getProductList();
        productList.sort(Comparator.comparingInt(Product::getSales));

        List<ProductDTO> tempList = new ArrayList();
        for (int i = 0; i < productList.size(); i++){
            tempList.add(new ProductDTO(productList.get(i)));
        }
        if (tempList.size() > num){
            return tempList.subList(0, num - 1);
        }

        return tempList.subList(0, tempList.size());
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
