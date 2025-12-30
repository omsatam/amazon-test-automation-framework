package stepDefinition;

import pages.LandingPage;
import pages.ProductPage;
import pages.ResultPage;
import pages.Topnav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testContext.TestContext;

public class ProductPageDefinition {
    private final LandingPage landingPage;
    private final ProductPage productPage;
    private final ResultPage resultPage;
    private final Topnav topNav;
    public ProductPageDefinition(TestContext testContext) {
        this.landingPage = testContext.getLandingPage();
        this.productPage = testContext.getProductPage();
        this.resultPage = testContext.getResultPage();
        this.topNav = testContext.getTopnav();
    }
    @Then("Verify Product Images Displayed Correctly")
    public void verify_product_images_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        productPage.verifyProductImages();
    }
    @Then("Verify All Product Page Items")
    public void verify_all_product_page_items() {
        // Write code here that turns the phrase above into concrete actions
        productPage.verifyProductPage();
    }

    @When("User Add Product To Cart")
    public void user_add_product_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        productPage.addToCart();
    }
    @Then("Check Cart Quantity")
    public void check_cart_quantity() {
        // Write code here that turns the phrase above into concrete actions
        productPage.checkCartQuantity();
    }
    @Then("Check Cart Quantity and Verify Cart Quantity Increased")
    public void verify_cart_quantity_increased() {
        // Write code here that turns the phrase above into concrete actions
        productPage.verifyCartQuantityIncreased(productPage.cartCount);
    }
    @When("User Adds product to wishlist")
    public void user_adds_product_to_wishlist() {
        productPage.addToWishlist();
    }
    @Then("Verify Wishlist page appears")
    public void verify_wishlist_page_appears() {
        // Write code here that turns the phrase above into concrete actions
        productPage.verifyWishlistPage();
    }
    @Then("Add item to wishlist")
    public void add_item_to_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        productPage.addproductToWishlist();
    }
    @Then("Go to Wishlist")
    public void go_to_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        topNav.goToWishlist();
    }
    @Then("Verify Product Available in Wishlist")
    public void verify_product_available_in_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.verifyProductinWishlist(resultPage.productName);
    }
    @Then("Delete Created Wishlist")
    public void delete_created_wishlist() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.deleteCreatedWishlist();
    }
    @And("User Begins Checkout")
    public void user_begins_checkout() {
        // Write code here that turns the phrase above into concrete actions
        productPage.beginCheckout();
    }
    @Then("Verify that Checkout page appears")
    public void verify_that_checkout_page_appears() {
        // Write code here that turns the phrase above into concrete actions
        landingPage.verifyCheckoutPage();
    }
    @When("User clicks on Buy product now")
    public void user_clicks_on_buy_product_now() {
        // Write code here that turns the phrase above into concrete actions
        productPage.buyProductNow();
    }


}