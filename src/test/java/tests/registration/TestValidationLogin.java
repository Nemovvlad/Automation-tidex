package tests.registration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.registration.RegisterPage;
import tests.TestInit;

public class TestValidationLogin extends TestInit {

    @Test
    public void checkValEmail() {
        Actions actions = new Actions(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        openUrl("https://tidex.com/login");
        actions.moveToElement(registerPage.getBtnLanguage()).click().perform();
        actions.moveToElement(registerPage.getBtnEng()).click().perform();
        String input = "gagaga";
        registerPage.getInputMail().sendKeys(input);
        Assert.assertEquals(registerPage.checkText1().getText(), "Email is not valid");
        actions.doubleClick(registerPage.getInputMail()).perform();
        registerPage.getInputMail().sendKeys(Keys.BACK_SPACE);

        Assert.assertEquals(registerPage.checkText1().getText(), "Field is required");
    }
    @Test
    public void checkValPassword() {
        Actions actions = new Actions(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        openUrl("https://tidex.com/login");
        actions.moveToElement(registerPage.getBtnLanguage()).click().perform();
        actions.moveToElement(registerPage.getBtnEng()).click().perform();
        String input = "1234";
        registerPage.getInputLoginPassword().sendKeys(input);
        actions.doubleClick(registerPage.getInputLoginPassword()).perform();
        registerPage.getInputLoginPassword().sendKeys(Keys.BACK_SPACE);
        Assert.assertEquals(registerPage.checkText1().getText(), "Field is required");
    }
}
