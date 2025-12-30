package base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PageBase {

    private static final Logger logger = LogManager.getLogger(PageBase.class);

    protected WebDriver driver;

    // Constructor for PicoContainer injection
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }


    public void closeBrowser(){
//        driver.quit();
    }
    public Properties getProerties() throws IOException {
        Properties props=new Properties();
        FileReader reader=new FileReader("./src/test/resources/config.properties");
        props.load(reader);
        return props;
    }
        // mouse clicks and actions
    public void navigateTo(String URL) throws IOException {
        driver.get(URL);
        driver.manage().window().maximize();
        logger.info("Webpage opened Successfully");
    }
    public void mouseOverToElement(By Elementlocator){
        WebElement ele = driver.findElement(Elementlocator);
        Actions action = new Actions(driver);
        action. moveToElement(ele).build().perform();
        logger.info("Mouse hover to Element "+ Elementlocator);
    }
    public void waitUntilElementVisible(By Elementlocator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Elementlocator));
        logger.info("Waited till element "+ Elementlocator +" to be visible");
    }
    public void waitUntilElementTextVisible(By Elementlocator,String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(driver -> {
            String textElement = driver.findElement(Elementlocator).getText();
            return textElement != null && textElement.trim().replaceAll("\\s+", " ")
                    .equalsIgnoreCase(text);
        });
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(Elementlocator,text));
        logger.info("Waited till element "+ Elementlocator +" text "+ text + " to be visible");
    }
    public void waitUntilElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(element));
        logger.info("Waited till element "+ element +" to be visible");
    }
    public void sleep(Integer milliSeconds) {
        double secondsLong = (double) milliSeconds;
        try {
            Thread.sleep(milliSeconds);
            logger.info("Waited For "+ secondsLong/1000 + " Seconds");
        } catch (Exception e) {
            logger.error(e.getMessage());
            // InterruptedException
        }
    }
    public void clickElementByText(String text){
        driver.findElement(By.partialLinkText(text)).click();
        logger.info("Clicked Element by Text "+text);
    }
    public void clickElementByExactText(String text){
        driver.findElement(By.linkText(text)).click();
        logger.info("Clicked Element by Exact Text "+text);
    }

    public void switchToNewTab(){
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        logger.info("Switched to new tab "+newTb.get(1));
    }
    public String getElementText(By ElementLocator){
        return driver.findElement(ElementLocator).getText();
    }
    public List<WebElement> getElements(By Elementlocator){
        return driver.findElements(Elementlocator);
    }
    public void clickElement(By Elementlocator){
        driver.findElement(Elementlocator).click();
        logger.info("Clicked Element "+Elementlocator);
    }
    public void scrollToElement(By ElementLocator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ElementLocator));
        logger.info("Scrolled to Element "+ ElementLocator);
    }
    public void scrollToElement(WebElement Element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
        logger.info("Scrolled to Element "+ Element);
    }
    public void clickElementbyJavascript(By ElementLocator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(ElementLocator));
        logger.info("Clicke element "+ ElementLocator);
    }
    public void setElement(By Elementlocator, String value){
        clearElement(Elementlocator);
        driver.findElement(Elementlocator).sendKeys(value);
        logger.info("Element "+ Elementlocator +" value set to "+ value + " Successfully");
    }
    public void isElementVisible(By Elementlocator){
        driver.findElement(Elementlocator).isDisplayed();
        logger.info("Element "+Elementlocator +" is Displayed Correctly");
    }
    public boolean isElementExists(By Elementlocator){
        try {
            return driver.findElement(Elementlocator).isDisplayed();
        }catch (NoSuchElementException e){
            logger.info("Element " + Elementlocator + "does not exists ");
            return false;
        }
    }
    public void isTextVisible(By Elementlocator, String text){
        logger.info(driver.findElement(Elementlocator).getText().trim().toLowerCase());
        logger.info(text.toLowerCase());
        Assert.assertTrue(driver.findElement(Elementlocator).getText().trim().toLowerCase().contains(text.trim().toLowerCase()));
        logger.info("Element "+ Elementlocator +"text is "+ text);
    }
public void clearElement(By ElementLocator){
        driver.findElement(ElementLocator).clear();
        logger.info("Element "+ElementLocator +" is  Cleared");
}
    protected String getProperty(String key) {
        return ConfigReader.get(key);
    }

    }


