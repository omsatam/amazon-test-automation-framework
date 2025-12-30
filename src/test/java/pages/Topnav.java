package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Topnav extends PageBase {
    private static final Logger logger = LogManager.getLogger(Topnav.class);
    private final By dropdownItems = By.xpath("//*[@id='searchDropdownBox']/option");
    private final By defaultDropdownSelector = By.xpath("//div[@id='nav-search-dropdown-card']/div/div/span");
    private final By signInSelector = By.id("nav-link-accountList-nav-line-1");
    private final By SignInLink =  By.id("nav-link-accountList");
    private final By createAccountButton =  By.id("createAccountSubmit");
    private final By autocompleteSelector = By.cssSelector("#nav-flyout-searchAjax > div.autocomplete-results-container");
    private final By SearchInputSelector = By.id("twotabsearchtextbox");
    private final By dropdown =  By.id("nav-search-dropdown-card");
    private final By resultsSelector = By.cssSelector("h1.a-size-base");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By recommendationsList = By.xpath("//*[@id='nav-flyout-searchAjax']/div[2]/div");
    private final By recommendedItem =  By.xpath("//*[@id='nav-flyout-searchAjax']/div/div/div/div[4]/div/div[1]");
    protected String SearchItem = getProperty("searchItem");
    private final By YourAccountLink =  By.xpath("//li/a/span[text()='Your Account']");
    private final By YourOrdersLink =  By.xpath("//li/a/span[text()='Your Orders']");
    private final By ReturnsOrdersSelector = By.id("nav-orders");
    private final By YourWishlistLink =  By.xpath("//li/a/span[text()='Your Wish List']");;
    private final By YourRecommendationsLink =  By.xpath("//li/a/span[text()='Your Recommendations']");
    private final By YourPrimeMembershipLink =  By.xpath("//li/a/span[text()='Your Prime Membership']");
    private final By YourPrimeVideoLink =  By.xpath("//li/a/span[text()='Your Prime Video']");
    private final By YourSubscribeLink =  By.xpath("//li/a/span[text()='Your Subscribe & Save Items']");
    private final By MembershpsSubscriptions =  By.xpath("//li/a/span[text()='Memberships & Subscriptions']");
    private final By YourAmazonBuisnessLink =  By.xpath("//li/a/span[text()='Register for a free Business Account']");
    private final By YourSellerAccountLink =  By.xpath("//li/a/span[text()='Your Seller Account']");
    private final By ManageYourContentLink =  By.xpath("//li/a/span[text()='Manage Your Content and Devices']");
    private final By SwitchAccountsLink =  By.id("nav-item-switch-account");
    protected String correctEmailInputSignup =  new String("testing45623@gmail.com");
    private final By continueButton =  By.id("continue");
    private final By createNewUserButton = By.xpath("//span[@id='intention-submit-button']/span/input");
    private final By emailInputSelector = By.id("ap_email_login");
    public Topnav(WebDriver driver) {
        super(driver);
    }
    //    String defaultDropdownText = "All";
    public void verifyDefaultDropdown(String text){
//        clickElement(defaultDropdownSelector);
        isTextVisible(defaultDropdownSelector,text);
    }
    public void changeDropdownCategoryandVerify(){
        List<WebElement> dropdownCategories = getElements(dropdownItems);
        for (WebElement dropdownItem:
                dropdownCategories) {
            waitUntilElementVisible(dropdown);
            clickElement(dropdown);
            String text = dropdownItem.getText();
            if (text != "All Categories"){
                waitUntilElementDisplayed(dropdownItem);
                dropdownItem.click();
                text.toLowerCase().contains(getElementText(defaultDropdownSelector));
                logger.info(text + " is equals to "+ getElementText(defaultDropdownSelector));
            }
        }
    }
    public void goToSignIn(){
        clickElement(signInSelector);
    }
    public void goToSignUp(){
        clickElement(signInSelector);
        setElement(emailInputSelector, correctEmailInputSignup);
        clickElement(continueButton);
        waitUntilElementVisible(createNewUserButton);
        clickElementbyJavascript(createNewUserButton);
    }
    public void typeInSearchBox(){
        setElement(SearchInputSelector,SearchItem);
    }
    public void checKRecommendations(){
        waitUntilElementVisible(autocompleteSelector);
        isElementVisible(autocompleteSelector);
        List<WebElement> recommendations = getElements(recommendationsList);
        for (WebElement recommendation:
                recommendations) {
            String text = recommendation.getText();
            text.toLowerCase().contains(SearchItem.toLowerCase());
            logger.info(text + " contains "+ SearchItem);
        }
    }
    public void searchForProduct(){
        clearElement(SearchInputSelector);
        setElement(SearchInputSelector,SearchItem);
        clickElement(searchButton);
    }
    public void searchFromRecommendations(){
        clickElement(recommendedItem);
    }
    public void verifySearchResults(){
        isElementVisible(resultsSelector);
    }
    public void goToWishlist(){
        waitUntilElementVisible(signInSelector);
        mouseOverToElement(signInSelector);
        clickElement(YourWishlistLink);
    }
    public void openReturnsOrders(){
        clickElement(ReturnsOrdersSelector);
    }

    public void openYourAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourAccountLink);
        clickElement(YourAccountLink);
    }

    public void openYourOrders() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourOrdersLink);
        clickElement(YourOrdersLink);
    }

    public void openYourRecommendations() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourRecommendationsLink);
        clickElement(YourRecommendationsLink);
    }

    public void openYourPrimeMembership() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourPrimeMembershipLink);
        clickElement(YourPrimeMembershipLink);
    }

    public void openYourPrimeVideo() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourPrimeVideoLink);
        clickElement(YourPrimeVideoLink);
    }

    public void openYourSubscribeSaveItems() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourSubscribeLink);
        clickElement(YourSubscribeLink);
    }

    public void openYourAmazonBusinessAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourAmazonBuisnessLink);
        clickElement(YourAmazonBuisnessLink);
    }

    public void openYourSellerAccount() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(YourSellerAccountLink);
        clickElement(YourSellerAccountLink);
    }

    public void openManageYourContentDevices() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(ManageYourContentLink);
        clickElement(ManageYourContentLink);
    }

    public void openMembershipsSubscriptions() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(MembershpsSubscriptions);
        clickElement(MembershpsSubscriptions);
    }

    public void openSwitchAccounts() {
        mouseOverToElement(signInSelector);
        waitUntilElementVisible(SwitchAccountsLink);
        clickElement(SwitchAccountsLink);
    }

}