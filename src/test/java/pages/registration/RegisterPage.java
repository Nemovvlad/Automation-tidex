package pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputMail() {
        return findElementByXpath("//*[@id=\"input_1\"]");
    }
    public List<WebElement> checkText() {
        return findElementsByXpath("//div[@class='tdx-input-label-error-wrapper__info mb-8']//span[@class='txt txt--10px mt-4 txt--red']");
    }
    //div[@class='tdx-input-label-error-wrapper__info mb-8']//span[@class='txt txt--10px mt-4 txt--red']

}
