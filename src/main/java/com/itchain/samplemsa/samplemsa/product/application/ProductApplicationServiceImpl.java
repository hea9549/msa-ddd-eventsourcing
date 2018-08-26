package com.itchain.samplemsa.samplemsa.product.application;

import com.itchain.samplemsa.samplemsa.product.ProductRepository;
import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    //TODO Api-gateway를 가지고있지 않고 URL로 ...
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String productId, String productName,
                           String description, int price, int stock) {
        Product product = new Product(productId, productName, description, price, stock, 0);
        productRepository.save(product);
    }

    public void deleteProduct(String productId) {
        // API-Gateway에서 product를 가져와야함
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

    public void addProductStock(String productId, int additionalStockNum){
        Product product = productRepository.findById(productId);
        product.addProductStock(additionalStockNum);
        productRepository.save(product);
    }

    public List<ProductDTO> getBestProduct(int num) {
        //TODO APi-gateway를 통해 sales가 가장 우수한 product들을 num 개수많큼 받아옴
        return null;
    }

    public List<ProductDTO> getProducts() {
        //TODO APi-gateway를 통해 모든 프로덕트의 리스트를 받아옴
        return null;
    }

    public List<ProductDTO> getProductsByCategory(String category) {
        //TODO Api-gateway를 통해 category에 맞는 리스트를 받아옴
        //Product를 ProductDTO에 맞게 변형

        return null;
    }


}
