package com.itchain.samplemsa.samplemsa.product.domain;

import com.itchain.samplemsa.samplemsa.product.ProductProjectionRepository;
import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductProjectionRepository repository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : repository.getProductList()){
            productDTOList.add(new ProductDTO(product));
        }
        return productDTOList;
    }
}
