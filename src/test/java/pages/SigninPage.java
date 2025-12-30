package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage extends PageBase {
    private final By emailInputSelector = By.id("ap_email_login");
    private final By emailSelector = By.id("ap_email");
    private final By continueButon = By.id("continue");
    private final By invalidEmailPhoneError = By.id("invalid-email-alert");
    private final By invalidPhoneError = By.id("invalid-phone-alert");
    private final By authorizationError = By.xpath("//div[contains(text(),'Your password is incorrect')]");
    private final By passwordInputSelector = By.xpath("//input[@id='ap_password']");
    private final By submitButon = By.id("signInSubmit");
    private final By noEmailAlert = By.id("empty-claim-alert");
    private final By incorrectOTPAlert = By.cssSelector("#verification-code-form > div.a-row.a-spacing-micro > div > div > div > div");
    private final By noPasswordAlert = By.id("auth-password-missing-alert");
    private final By getOTPButon = By.id("auth-login-via-otp-btn");
    private final By OTPSelector = By.id("cvf-input-code");
    private final By submitOTPButton = By.id("cvf-submit-otp-button");
    public SigninPage(WebDriver driver) {
        super(driver);
    }
    protected String userNumber =  getProperty("UserMobileNumber");
    protected String userPassword = getProperty("UserPassword");
    public String UserName = getProperty("username");
    public void verifySignInPage(){
        waitUntilElementVisible(emailInputSelector);
        isElementVisible(emailInputSelector);
    }
    public void verifySignInPageReturnOrders(){
        waitUntilElementVisible(emailSelector);
        isElementVisible(emailSelector);
    }
    public void enterEmail(String Email){
        clearElement(emailInputSelector);
        setElement(emailInputSelector, Email);
        clickElement(continueButon);
    }
    public void verifyIncorrectEmailNumberError(){
        isElementVisible(invalidEmailPhoneError);
    }
    public void verifyIncorrectNumberError(){
        isElementVisible(invalidPhoneError);
    }
    public void verifyIncorrectPasswordError(){
        isElementVisible(authorizationError);
    }
    public void enterPassword(String Password){
        setElement(passwordInputSelector, Password);
        clickElement(submitButon);
    }
    public void clickContinueWithoutInput(){
        clickElement(continueButon);
    }
    public void verifyErrorWithoutInput(){
        clickElement(continueButon);
        isElementVisible(noEmailAlert);
    }
    public void verifyPasswordsPage(){
        waitUntilElementVisible(passwordInputSelector);
        isElementVisible(passwordInputSelector);
    }
    public void submitWithoutPassword(){
        clickElement(submitButon);
        isElementVisible(noPasswordAlert);
    }
    public void enterOTP(String OTP){
        clickElement(getOTPButon);
        setElement(OTPSelector,OTP);
        clickElement(submitOTPButton);
    }
    public void verifyErrorIncorrectOTP(){
        isElementVisible(incorrectOTPAlert);
    }
    public void signInWithValidCredentials(){
        setElement(emailInputSelector, userNumber);
        clickElement(continueButon);
        waitUntilElementVisible(passwordInputSelector);
        setElement(passwordInputSelector,userPassword);
        clickElement(submitButon);
    }
}