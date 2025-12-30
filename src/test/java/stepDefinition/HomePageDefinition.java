package stepDefinition;

import pages.HomePage;
import pages.LandingPage;
import pages.SigninPage;
import pages.Topnav;
import testContext.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class HomePageDefinition {
    private final HomePage homePage;
    private final LandingPage landingPage;
    private final Topnav topNav;
    private final SigninPage signinPage;

    // PicoContainer automatically injects dependencies
    public HomePageDefinition(TestContext testContext) {
        this.homePage = testContext.getHomePage();
        this.landingPage = testContext.getLandingPage();
        this.topNav = testContext.getTopnav();
        this.signinPage = testContext.getSigninPage();
    }

    //
//    public homePageDefinition(WebDriver driver) {
//        super(driver);
//    }
//    homePage homePage = new homePage(driver);
//    @AfterStep
//    public void takeScreenshot(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            //            System.out.println("taking screenshot");
//            File screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//            byte[] filecontent = FileUtils.readFileToByteArray(screenshot);
//            scenario.attach(filecontent, "image/png", "image");
//        }
//    }

    @Given("User is on Amazon Landing Page")
    public void user_is_on_amazon_landing_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        homePage.goToApplication();
    }

    @Given("User Close Browser")
    public void user_close_browser() {
        // Write code here that turns the phrase above into concrete actions
        homePage.closeBrowser();
    }

    @Given("Verify Default language is {string}")
    public void verify_default_language_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifyDefaultLangusge(string);
    }

    @When("User Changes Default Language to {string}")
    public void user_changes_default_language_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        homePage.changeDefaultLanguageTo(string);
    }

    @Then("Verify Language Changed to {string}")
    public void verify_language_changed_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifytChangedLanguage(string);
    }

    @When("User Opens Menu")
    public void user_opens_menu() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.openMenu();
    }

    @Then("Check Menu Opened Successfully")
    public void check_menu_opened_successfully() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.checkMenuOpened();
    }

    @When("User Opens {string} Page")
    public void user_opens_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        landingPage.goToPage(string);
    }

    @Then("Check {string} Page Opened Successfully")
    public void check_page_opened_successfully(String string) {
        // Write code here that turns the phrase above into concrete actions
        landingPage.verifyPageOpened(string);
    }

    @When("Opens Amazon Pay")
    public void opens_amazon_pay() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.openAmazonPay();
    }

    @Then("Check Amazon Pay opened")
    public void check_amazon_pay_opened() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.checkAmazonPayOpened();
    }

    @When("User Opens Amazon Fresh Page")
    public void user_opens_amazon_fresh_page() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.openAmazonFreshPage();
    }

    @Then("Check Amazon Fresh Page opened")
    public void check_amazon_fresh_page_opened() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.checkAmazonFreshPageOpened();
    }

    @Then("Verify Username Displayed")
    public void verify_username_displayed() {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifyUserNameforAuthorisedUser(signinPage.UserName);
    }

    @Then("Verify Returns & Orders is Displayed")
    public void verify_returns_orders_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        topNav.openReturnsOrders();
        landingPage.verifyReturnsOrdersPageDisplayed();
    }

    @Then("Verify Every Item of Your Account Section for Authorised User")
    public void verify_every_item_of_your_account_section_for_authorised_user() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        topNav.openYourAccount();
        landingPage.verifyYourAccountPage();
        topNav.openYourOrders();
        landingPage.verifyReturnsOrdersPageDisplayed();
        topNav.goToWishlist();
        landingPage.verifyWishListPage();
        topNav.openYourRecommendations();
        landingPage.verifyYourRecommendationsPage();
        topNav.openYourPrimeMembership();
        landingPage.verifyPrimeMembershipPage();
        topNav.openYourPrimeVideo();
        landingPage.verifyYourPrimeVideoPage();
        homePage.goToApplication();
        topNav.openYourSubscribeSaveItems();
        landingPage.verifyYourSubscribeSavePage();
        topNav.openMembershipsSubscriptions();
        landingPage.verifyMembershipsSubscriptionsPage();
        topNav.openYourAmazonBusinessAccount();
        landingPage.verifyYourAmazonBusinessAccountPage();
        topNav.openYourSellerAccount();
        landingPage.verifyPageOpened("Sell");
        topNav.openManageYourContentDevices();
        landingPage.verifyManageYourContentDevicesPage();
        topNav.openSwitchAccounts();
        landingPage.VerifySwitchAccountsPage();
    }

    @Then("Verify Username is not Displayed")
    public void verify_username_is_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        homePage.verifyUserNameforUnauthorisedUser();
    }

    @Then("Verify Returns & Orders is not Displayed")
    public void verify_returns_orders_is_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        topNav.openReturnsOrders();
        signinPage.verifySignInPageReturnOrders();
    }

    @Then("Verify Every Item of Your Account Section for Unauthorised User")
    public void verify_every_item_of_your_account_section_for_unauthorised_user() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        topNav.openYourAccount();
        landingPage.verifyYourAccountPage();
        topNav.openYourOrders();
        signinPage.verifySignInPageReturnOrders();
        homePage.goToApplication();
        topNav.goToWishlist();
        landingPage.verifyWishListPage();
        topNav.openYourRecommendations();
        landingPage.verifyYourRecommendationsPage();
        topNav.openYourPrimeMembership();
        signinPage.verifySignInPageReturnOrders();
        homePage.goToApplication();
        topNav.openYourPrimeVideo();
        landingPage.verifyYourPrimeVideoPage();
        homePage.goToApplication();
        topNav.openYourSubscribeSaveItems();
        signinPage.verifySignInPageReturnOrders();
        homePage.goToApplication();
        topNav.openMembershipsSubscriptions();
        signinPage.verifySignInPageReturnOrders();
        homePage.goToApplication();
        topNav.openYourAmazonBusinessAccount();
        landingPage.verifyYourAmazonBusinessAccountPage();
        homePage.goToApplication();
        topNav.openYourSellerAccount();
        landingPage.verifyYourSellerAccount();
        topNav.openManageYourContentDevices();
        signinPage.verifySignInPageReturnOrders();
    }
}