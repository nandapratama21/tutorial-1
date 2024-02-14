package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
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
class ProductControllerTest {
    @InjectMocks
    private ProductController productController;
    @Mock
    private Model model;

    private Product product;

    @Mock
    private ProductService productService;


    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("71af6af6-3bd6eb55-8e9f1c394-60e8860");
        product.setProductName("Pak Andika");
        product.setProductQuantity(250);
    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("product"), any(Product.class));

    }

    @Test
    void testCreateProductPost() {
        String redirectUrl = productController.createProductPost(product, model);

        assertEquals("redirect:/product/list", redirectUrl);
        verify(productService).create(product);
    }

    @Test
    void testProductListPage() {
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(product);
        when(productService.findAll()).thenReturn(mockProducts);

        String viewName = productController.productListPage(model);

        verify(productService).findAll();
        verify(model).addAttribute("products", mockProducts);

        assertEquals("productList", viewName);
    }

    @Test
    void testEditProductPage() {
        String viewName = productController.editProductPage("71af6af6-3bd6eb55-8e9f1c394-60e8860", model);

        assertEquals("editProduct", viewName);
        verify(model).addAttribute(eq("product_toedit"), any(Product.class));
        verify(model).addAttribute(eq("productId"), any(String.class));
    }

    @Test
    void testEditProductPost() {
        Product editedProduct = new Product();
        product.setProductId("831i572g7-4ce7fc66-9f0g1d405-71f9971");
        product.setProductName("Pak Rio");
        product.setProductQuantity(125);

        String redirectUrl = productController.editProductPost(editedProduct,"71af6af6-3bd6eb55-8e9f1c394-60e8860", model);

        assertEquals("redirect:/product/list", redirectUrl);
        verify(productService).edit(editedProduct, "71af6af6-3bd6eb55-8e9f1c394-60e8860");
    }

    @Test
    void testDeleteProduct() {
        String redirectUrl = productController.deleteProduct("71af6af6-3bd6eb55-8e9f1c394-60e8860", model);

        assertEquals("redirect:/product/list", redirectUrl);
        verify(productService).delete("71af6af6-3bd6eb55-8e9f1c394-60e8860");
    }


}