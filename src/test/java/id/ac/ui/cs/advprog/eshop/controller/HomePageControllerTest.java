package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageControllerTest {

    @Test
    void testHomepage() {
        // Arrange
        HomePageController homePageController = new HomePageController();

        // Act
        String viewName = homePageController.Homepage();

        // Assert
        assertEquals("HomePage", viewName);
    }
}
