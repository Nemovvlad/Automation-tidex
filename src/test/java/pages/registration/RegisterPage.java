package pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBtnLanguage() {
        return findElementByXpath("//*[@id=\"base-header\"]/div/div/div[3]/div/span[2]/div/div[1]");
    }

    public WebElement getBtnEng() {
        return findElementByXpath("//*[@id=\"base-header\"]/div/div/div[3]/div/span[2]/div/div[2]/div/span[1]/div/div/div[1]/span/span");
    }

    public WebElement getInputMail() {
        return findElementByXpath("//*[@id=\"input_1\"]");
    }

    public WebElement checkText1() {
        return findElementByXpath("//div[@class='tdx-input-label-error-wrapper__info mb-8']//span");
    }

    public WebElement getInputPassword() {
        return findElementByXpath("//*[@id=\"input_2\"]");
    }

    public WebElement errorMsgTex() {
        return findElementByXpath("//div[@class='tdx-input-label-error-wrapper__info mb-8']//span");
    }

    public WebElement getInputConfirmPassword() {
        return findElementByXpath("//*[@id=\"input_3\"]");
    }

    public WebElement checkTextConfirmPassword() {
        return findElementByXpath("//div[@class='tdx-input-label-error-wrapper__info mb-8']//span");
    }
    public WebElement getInputLoginPassword() {
        return findElementByXpath("//*[@id=\"input_2\"]");
    }

}
