package tests.registration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.registration.RegisterPage;
import tests.TestInit;

import java.util.Locale;


public class TestValidationReg extends TestInit {

    @Test
    public void checkValidMail() {
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("https://tidex.com/register");
        String input = "gogolyly";
        registerPage.getInputMail().sendKeys(input + "\n ");
        for (WebElement element : registerPage.checkText1()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Email is not valid"));
        }
    }
    @Test
    public void checkValidPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("https://tidex.com/register");

        String input1 = "фывап";
        registerPage.getInputPassword().sendKeys(input1 + "\n ");
        for (WebElement element : registerPage.checkTextPassword1()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Only latin letters or numbers and chars"));
        }

        String input2 = "1234";
        registerPage.getInputPassword().sendKeys(input2 + "\n ");
        for (WebElement element : registerPage.checkTextPassword2()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Min length is 8"));
        }

        String input3 = "qqqqqqqq";
        registerPage.getInputPassword().sendKeys(input3 + "\n ");
        for (WebElement element : registerPage.checkTextPassword3()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("At least 1 uppercase alphabetical character"));
        }

        String input4 = "qwertyuiopasdfghjklzx";
        registerPage.getInputPassword().sendKeys(input4 + "\n ");
        for (WebElement element : registerPage.checkTextPassword4()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Max length is 20"));
        }
    }
    @Test
    public void checkValidConfirmPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("https://tidex.com/register");
        String input5 = "qwertyuiopasdfghjklzx";
        registerPage.getInputConfirmPassword().sendKeys(input5 + "\n ");
        for (WebElement element : registerPage.checkTextConfirmPassword()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Field should match Password"));
        }
    }
}

