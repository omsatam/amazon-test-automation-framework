
package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import testContext.TestContext;

public class SearchDefinition{
    private final Topnav topNav;
    public SearchDefinition(TestContext testContext){
        this.topNav = testContext.getTopnav();
    }
    @And("Default Search Dropdown Category is {string}")
    public void default_search_dropdown_category_is(String string) {
        topNav.verifyDefaultDropdown(string);
    }
    @When("User Changes Dropdown Category The same should be displayed")
    public void user_changes_dropdown_category_the_same_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        topNav.changeDropdownCategoryandVerify();
    }
    @Then("Check Recommendations are Displaying correctly")
    public void check_recommendations_are_displaying_correctly() {
        // Write code here that turns the phrase above into concrete actions
        topNav.checKRecommendations();
    }
    @When("User Type in Searchbox")
    public void user_type_in_searchbox() {
        // Write code here that turns the phrase above into concrete actions
        topNav.typeInSearchBox();
    }
    @When("User Search for Product")
    public void user_search_for_product() {
        // Write code here that turns the phrase above into concrete actions
        topNav.searchForProduct();
    }
    @When("User Search From Recommended Product")
    public void user_search_from_recommended_product() {
        // Write code here that turns the phrase above into concrete actions
        topNav.searchFromRecommendations();
    }
    @Then("Verify Search Results")
    public void verify_search_results() {
        // Write code here that turns the phrase above into concrete actions
        topNav.verifySearchResults();
    }

}

