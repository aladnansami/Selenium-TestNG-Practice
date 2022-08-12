package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {
    @FindBy(id="search_query_top")
    WebElement txtSearch;
    @FindBy(name="submit_search")
    WebElement btnSearch;
    @FindBy(className = "heading-counter")
    WebElement lblResult;
    @FindBy(tagName = "img")
    List<WebElement> imgProduct;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement btnAddCart;
    @FindBy(css = "[title='Proceed to checkout']")
    WebElement btnCheckout;
    @FindBy(className = "page-heading")
    WebElement lblSummaryPage;
    WebDriver driver;

    public OrderPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String searchProduct(String product){
        txtSearch.sendKeys(product);
        btnSearch.click();
        return lblResult.getText();

    }
    public Boolean chooseProduct(){
        imgProduct.get(14).click();
        return btnAddCart.isDisplayed();
    }
    public Boolean addToCart(){
        btnAddCart.click();
        return btnCheckout.isDisplayed();
    }
    public String checkProductSumary(){
        btnCheckout.click();
        return lblSummaryPage.getText();

    }
}
