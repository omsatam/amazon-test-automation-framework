package stepDefinition;

import pages.ProductPage;
import pages.ResultPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testContext.TestContext;

public class SearchresultsPageDefinition {
    private final ProductPage productPage;
    private final ResultPage resultPage;
    public SearchresultsPageDefinition(TestContext testContext){
        this.productPage = testContext.getProductPage();
        this.resultPage = testContext.getResultPage();
    }
    @When("User Selects Product From Search Results")
    public void user_selects_product_from_search_results() {
        // Write code here that turns the phrase above into concrete actions
        resultPage.selectProductFromResults();
    }
    @Then("Open Product Image and Verify it Opened")
    public void open_product_image_and_verify_it_opened() {
        // Write code here that turns the phrase above into concrete actions
        productPage.openProductImageandVerify();
    }
    @Then("Select Product Images and Verify Results")
    public void select_product_images_and_verify_results() {
        // Write code here that turns the phrase above into concrete actions
        productPage.selectProductImageandVerify();
    }
    @Then("Verify Correct Product Opened")
    public void verify_correct_product_opened() {
        // Write code here that turns the phrase above into concrete actions
        productPage.verifyCorrectProductOpened(resultPage.productName);
    }

    @Then("^User Changes to (.+) stars & up and verify results$")
    public void userChangesToGivenStarsStarsUpAndVerifyResults(int stars) {
        resultPage.selectGivenStarsVerifyResults(stars);
    }

    @Then("User Changes Filter To {string}")
    public void userChangesFilterTo(String arg0) {

    }

    @Then("Verify Default Sort By Feature")
    public void verifyDefaultSortByFeature() {
        resultPage.verifyDefaultSortBy();
    }

    @Then("^User Changes Filter To (.+) and Verify Results$")
    public void user_changes_filter_to_and_verify_results(String filterValue) {
        resultPage.changeFilterVerifyResults(filterValue);
    }

    @Then("^User Changes Brands (.+) and Verify Results")
    public void userChangesBrandsBrandNamesAndVerifyResults(String brandName) {
        resultPage.selectBrandNameVerifyResults(brandName);
    }

    @Then("^User Changes Discount Category to (.+) and Verify Results$")
    public void userChangesDiscountCategoryToDiscountCategoryAndVerifyResults(String DiscountCategory) {
        resultPage.changeDiscountCategoryVerifyResults(DiscountCategory);
    }

    @Then("^User Changes to Given Price Range (.+) and verify results$")
    public void userChangesToGivenPriceRangeGivenPriceRangeAndVerifyResults(int priceRange) {
        resultPage.changePriceRangeVerifyResults(priceRange);
    }
}