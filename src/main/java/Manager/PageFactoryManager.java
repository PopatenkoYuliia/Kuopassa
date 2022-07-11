package Manager;

import Pages.CustomerServicePage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchPage;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CustomerServicePage getCustomerServicePage() {
        return new CustomerServicePage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }
}
