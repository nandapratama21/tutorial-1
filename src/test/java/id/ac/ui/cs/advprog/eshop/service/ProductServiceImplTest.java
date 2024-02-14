package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreate() {
        Product product = new Product();
        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
        assertEquals(product.getProductId(), createdProduct.getProductId());
        assertEquals(product.getProductName(), createdProduct.getProductName());
        assertEquals(product.getProductQuantity(), createdProduct.getProductQuantity());
    }

    @Test
    void testFindAll() {
        List<Product> allProduct = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();
        allProduct.add(product1);
        allProduct.add(product2);

        when(productRepository.findAll()).thenReturn(allProduct.iterator());

        List<Product> productList = productService.findAll();
        assertEquals(2, allProduct.size());
    }

    @Test
    void testDeleteProduct_Success() {
        Product product = new Product();
        product.setProductId("71af6af6-3bd6eb55-8e9f1c394-60e8860");
        product.setProductName("Pak Andika");
        product.setProductQuantity(10);

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        when(productRepository.delete(product.getProductId()))
                .thenReturn(productList.removeIf(productInList ->
                        productInList.getProductId().equals(product.getProductId())));

        boolean validDeleteId = productService.delete(product.getProductId());
        assertEquals(0, productList.size());
        assertTrue(validDeleteId);
    }

    @Test
    void testDeleteProduct_Failure() {
        Product product = new Product();
        product.setProductId("71af6af6-3bd6eb55-8e9f1c394-60e8860");
        product.setProductName("Pak Andika");
        product.setProductQuantity(10);

        when(productRepository.delete(product.getProductId())).thenReturn(false);

        boolean result = productService.delete(product.getProductId());

        verify(productRepository).delete(product.getProductId());
        assertFalse(result);

    }

    @Test
    void testEdit() {
        Product productEdit = new Product();
        productEdit.setProductId("71af6af6-3bd6eb55-8e9f1c394-60e8860");
        productEdit.setProductName("Pak Andika");
        productEdit.setProductQuantity(10);

        List<Product> productList = new ArrayList<>();
        productList.add(productEdit);

        Product editedProduct = new Product();
        editedProduct.setProductName("Pak Dio");
        editedProduct.setProductQuantity(15);

        when(productRepository.edit(any(Product.class), any(String.class)))
                .thenAnswer(invocation -> {
                    String productId = invocation.getArgument(1);
                    Product productToEditInRepo = productList.stream().filter(product -> product.getProductId().equals(productId)).findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + productId));

                    Product editedProductInRepo = invocation.getArgument(0);
                    productToEditInRepo.setProductName(editedProductInRepo.getProductName());
                    productToEditInRepo.setProductQuantity(editedProductInRepo.getProductQuantity());

                    return productToEditInRepo;
                });

        productService.edit(editedProduct, productEdit.getProductId());
        assertEquals(editedProduct.getProductName(), productEdit.getProductName());
        assertEquals(editedProduct.getProductQuantity(), productEdit.getProductQuantity());

        // The ID is different althrough the name and quantity same
        assertNotEquals(editedProduct.getProductId(), productEdit.getProductId());

    }

}