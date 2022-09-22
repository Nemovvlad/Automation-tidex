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

        openUrl("https://tidex.com/ru/register");
        String input = "gogolyly";

        registerPage.getInputMail().sendKeys(input + "\n ");

        for (WebElement element : registerPage.checkText()) {
            Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains("Неверный адрес электронной почты"));

        }
    }
}
