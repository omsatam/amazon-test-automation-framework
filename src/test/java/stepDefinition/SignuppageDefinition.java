package stepDefinition;

import pages.SignupPage;
import pages.Topnav;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testContext.TestContext;

public class SignuppageDefinition {
    private final SignupPage signupPage;
    private final Topnav topNav;
    public SignuppageDefinition(TestContext testContext){
        this.signupPage = testContext.getSignupPage();
        this.topNav = testContext.getTopnav();
    }
    @Given("User Navigate to Sign Up page")
    public void user_navigate_to_sign_up_page() {
        // Write code here that turns the phrase above into concrete actions
        topNav.goToSignUp();
    }
    @Then("Check all Manadotory Fields of SignUp page")
    public void check_all_manadotory_fields_of_sign_up_page() {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkAllManadotoryFields();
    }
    @When("User Enters Name Field (.+)$")
    public void user_enters_name_field_(String Name) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.enterName(Name);
    }
    @Then("Verify that User Navigated To Next Screen on Signup page")
    public void verify_that_user_navigated_to_next_screen_on_signup_page() {
        // Write code here that turns the phrase above into concrete actions
        signupPage.verifyNextPageSignup();
    }
    @When("^User User Enters Incorrect Phone Number (.+) on Signup page then Error message should displayed")
    public void user_user_enters_incorrect_phone_number_on_signup_page_then_error_message_should_displayed(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForIncorrectNumber(PhoneNumber);
    }
    @Then("User Enters Correct Phone Number (.+)$")
    public void user_enters_correct_phone_number_(String PhoneNumber) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForCorrectNumber(PhoneNumber);
    }
    @When("^User User Enters Incorrect Email Address (.+) on Signup page then Error message should displayed")
    public void user_user_enters_incorrect_email_address_on_signup_page_then_error_message_should_displayed(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForIncorrectEmail(EmailAddress);
    }
    @Then("User Enters Correct Email Address (.+)$")
    public void user_enters_correct_email_address_(String EmailAddress) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForCorrectEmail(EmailAddress);
    }
    @When("^User Enters Incorrect Password (.+) on Signup page then Error message should displayed$")
    public void user_enters_incorrect_password_on_signup_page_then_error_message_should_displayed(String Password) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForIncorrectPassword(Password);
    }
    @Then("User Enters Correct Password (.+)$")
    public void user_enters_correct_password_(String Password) {
        // Write code here that turns the phrase above into concrete actions
        signupPage.checkForCorrectPassword(Password);
    }

}