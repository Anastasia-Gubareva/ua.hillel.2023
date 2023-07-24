package tests.pageObject;

import hillel.pages.CheckBoxesPage;
import hillel.pages.LoginPage;
import hillel.pages.SecurePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRun extends  BaseTest {

    @Test

    public void ButtonClickChallengingDom() {
        openMainPage()
                .goChallengingDOM().clickButtons().showValuesColum();
    }

    @Test
    public void checkBoxTest() {
        CheckBoxesPage checkBoxesPage = openMainPage().goToCheckBoxPage()
                .checkBoxTest();
    }

    @Test
    public void displayUser() {
        openMainPage().goToHowers().displayUser();
    }

    @Test
    public void validLogin() {
        SecurePage secureAreaPage = openMainPage().goToLogInPage()
                .setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLoginButton();

        String text = secureAreaPage.getSuccessToast();
        Assert.assertTrue(text.contains("You logged into a secure area!"));
    }

    @Test
    public void invalidLogin() {
        openMainPage().goToLogInPage()
                .setUsername("fall")
                .setPassword("123455556")
                .clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        String text = loginPage.getErrorToast();
        Assert.assertTrue(text.contains("Your username is invalid!"));
    }
}

