package tests.registration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.registration.RegisterPage;
import tests.TestInit;


public class TestValidationReg extends TestInit {

    @Test
    public void checkValidEmail() {
        Actions actions = new Actions(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        openUrl("https://tidex.com/register");
        actions.moveToElement(registerPage.getBtnLanguage()).click().perform();
        actions.moveToElement(registerPage.getBtnEng()).click().perform();
        String input = "gogolyly";
        registerPage.getInputMail().sendKeys(input);
        Assert.assertEquals(registerPage.checkText1().getText(), "Email is not valid");
        actions.doubleClick(registerPage.getInputMail()).perform();
        registerPage.getInputMail().sendKeys(Keys.BACK_SPACE);

        Assert.assertEquals(registerPage.checkText1().getText(), "Field is required");
    }

    @Test
    public void checkValidPassword() {
        Actions actions = new Actions(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("https://tidex.com/register");
        actions.moveToElement(registerPage.getBtnLanguage()).click().perform();
        actions.moveToElement(registerPage.getBtnEng()).click().perform();

        String input1 = "фывап";
        registerPage.getInputPassword().sendKeys(input1);
        Assert.assertEquals(registerPage.errorMsgTex().getText(), "Only latin letters or numbers and chars");
        actions.doubleClick(registerPage.getInputPassword()).perform();
        registerPage.getInputPassword().sendKeys(Keys.BACK_SPACE);

        String input2 = "1234";
        registerPage.getInputPassword().sendKeys(input2);
        Assert.assertEquals(registerPage.errorMsgTex().getText(), "Min length is 8");
        actions.doubleClick(registerPage.getInputPassword()).perform();
        registerPage.getInputPassword().sendKeys(Keys.BACK_SPACE);

        String input3 = "qqqqqqqq";
        registerPage.getInputPassword().sendKeys(input3);
        Assert.assertEquals(registerPage.errorMsgTex().getText(), "At least 1 uppercase alphabetical character");
        actions.doubleClick(registerPage.getInputPassword()).perform();
        registerPage.getInputPassword().sendKeys(Keys.BACK_SPACE);

        String input4 = "qwertyuiopasdfghjklzx";
        registerPage.getInputPassword().sendKeys(input4);
        Assert.assertEquals(registerPage.errorMsgTex().getText(), "Max length is 20");
    }

    @Test
    public void checkValidConfirmPassword() {
        Actions actions = new Actions(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("https://tidex.com/register");
        actions.moveToElement(registerPage.getBtnLanguage()).click().perform();
        actions.moveToElement(registerPage.getBtnEng()).click().perform();

        String input5 = "qwertyuiopasdfghjklzx";
        registerPage.getInputConfirmPassword().sendKeys(input5);
        Assert.assertEquals(registerPage.checkTextConfirmPassword().getText(), "Field should match Password");
    }
}
