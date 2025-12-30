package testContext;

import pages.*;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private WebDriver driver;

    private HomePage homePage;
    private LandingPage langingPage;
    private SigninPage signinPage;
    private SignupPage signupPage;
    private ProductPage productPage;
    private ResultPage resultPage;
    private Topnav topnav;
    // add other pages here

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public LandingPage getLandingPage() {
        if (langingPage == null) {
            langingPage = new LandingPage(driver);
        }
        return langingPage;
    }
    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage(driver);
        }
        return productPage;
    }
    public ResultPage getResultPage() {
        if (resultPage == null) {
            resultPage = new ResultPage(driver);
        }
        return resultPage;
    }
    public SigninPage getSigninPage() {
        if (signinPage == null) {
            signinPage = new SigninPage(driver);
        }
        return signinPage;
    }
    public SignupPage getSignupPage() {
        if (signupPage == null) {
            signupPage = new SignupPage(driver);
        }
        return signupPage;
    }
    public Topnav getTopnav() {
        if (topnav == null) {
            topnav = new Topnav(driver);
        }
        return topnav;
    }



}
