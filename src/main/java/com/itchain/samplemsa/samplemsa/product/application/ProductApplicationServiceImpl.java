package com.itchain.samplemsa.samplemsa.product.application;

import com.itchain.samplemsa.samplemsa.product.ProductRepository;
import com.itchain.samplemsa.samplemsa.product.domain.Product;
import com.itchain.samplemsa.samplemsa.product.domain.ProductService;
import com.itchain.samplemsa.samplemsa.product.domain.dto.ProductDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    //TODO Api-gateway를 가지고있지 않고 URL로 ...
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

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

    public void addProductStock(String productId, int additionalStockNum) {
        Product product = productRepository.findById(productId);
        product.addProductStock(additionalStockNum);
        productRepository.save(product);
    }

    public List<ProductDTO> getBestProduct(int num) {
        List<ProductDTO> productDTOList = productService.getAllProducts();
        productDTOList.sort(Comparator.comparingInt(ProductDTO::getSales));
        return productDTOList.subList(0, num);
    }

    public List<ProductDTO> getProductSortByProductName(int num){
        List<ProductDTO> productDTOList = productService.getAllProducts();
        productDTOList.sort(Comparator.comparing(ProductDTO::getProductName));
        return productDTOList.subList(0, num);
    }

}
