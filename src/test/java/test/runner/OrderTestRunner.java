package test.runner;

import base.Setup;
import pages.OrderPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTestRunner extends Setup {
    OrderPage orderPage;
    @Test(priority = 1,description = "User can search product")
    public void searchProduct(){
        driver.get("http://automationpractice.com/");
        orderPage=new OrderPage(driver);
        String res= orderPage.searchProduct("dress");
        Assert.assertTrue(res.contains("results have been found"));
        Allure.description("User can search product successfully");
    }
    @Test(priority = 2, description = "User can choose product")
    public void chooseProduct(){
        orderPage=new OrderPage(driver);
        boolean found= orderPage.chooseProduct();
        Assert.assertTrue(found);
        Allure.description("User can choose product from the product list");
    }
    @Test(priority = 3, description = "User can add cart successfully")
    public void addToCart(){
        orderPage=new OrderPage(driver);
        boolean found= orderPage.addToCart();
        Assert.assertTrue(found);
        Allure.description("User added the product into card");
    }
    @Test(priority = 4, description = "User can see product summary")
    public void checkProductSumary(){
        orderPage=new OrderPage(driver);
        String summaryText= orderPage.checkProductSumary();
        Assert.assertTrue(summaryText.contains("SHOPPING-CART SUMMARY"));
        Allure.description("User can view product summary before checkout");
    }
}
