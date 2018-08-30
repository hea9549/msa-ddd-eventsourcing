package com.itchain.samplemsa.samplemsa.product;

import com.itchain.samplemsa.samplemsa.TestApplication;
import com.itchain.samplemsa.samplemsa.product.application.ProductApplicationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = TestApplication.class)
@ActiveProfiles("test")
public class ProductApplicationServiceTest {

    @Autowired
    private ProductApplicationServiceImpl productApplicationService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddProduct() {
        productApplicationService.addProduct("product1", "jacket", "awesome jacket", 10000, 100);

        Assert.assertEquals("jacket", productRepository.findById("product1").getProductName());
    }

    @Test
    public void testDeleteProduct() {
        productApplicationService.addProduct("product1", "jacket", "awesome jacket", 10000, 100);
        productApplicationService.deleteProduct("product1");
        Assert.assertNull(productRepository.findById("product1").getID());

    }

    @Test
    public void testUpdateProduct() {
        productApplicationService.addProduct("product1", "jacket", "awesome jacket", 10000, 100);
        productApplicationService.updateProduct("product1", "green jacket","awesome green jacket", 10000);
        Assert.assertEquals("green jacket",productRepository.findById("product1").getProductName());
        Assert.assertEquals("awesome green jacket", productRepository.findById("product1").getDescription());
    }

    @Test
    public void testSoldProduct(){
        productApplicationService.addProduct("product1", "jacket", "awesome jacket", 10000, 5);
        productApplicationService.soldProduct("product1", 3);
        Assert.assertEquals(2, productRepository.findById("product1").getStock());
        Assert.assertEquals(3, productRepository.findById("product1").getSales());
    }

    @Test
    public void testAddProductStock(){
        productApplicationService.addProduct("product1", "jacket", "awesome jacket", 10000, 5);
        productApplicationService.addProductStock("product1",5);
        Assert.assertEquals(10, productRepository.findById("product1").getStock());
    }

}
