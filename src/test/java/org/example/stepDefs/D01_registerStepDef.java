package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_Register register = new P01_Register();


    @Given("user go to register page")
    public void registerPage(){
        register.registerLink().click();
    }

    @When("user choose Gender")
    public void userChooseGender() {
        register.genderCheckBox().click();
    }


    @And("user insert valid first name")
    public void insertFirstName() {
        register.FirstNameTxtField().sendKeys("Abdelrahman");
    }


    @And("user insert valid last name")
    public void insertLastName() {
        register.LastNameTxtField().sendKeys("Wael");
    }


    @And("user select valid birth date")
    public void selectBirthDate() {
        Select select = new Select(register.birthDayDropDown());
        select.selectByValue("23");

        select = new Select(register.BirthMonthDropDown());
        select.selectByValue("6");

        select = new Select(register.BirthYearDropDown());
        select.selectByValue("1994");
    }


    @And ("user insert valid email address")
    public void insertEmail() {
        register.emailAddressTxtField().sendKeys(register.validEmail());
    }


    @And ("user insert valid password")
    public void insertPassword() {
        register.passwordTxtField().sendKeys(register.validPassword());
    }

    @And ("user insert again the same valid password")
    public void confirmPassword() {
        register.confirmPassTxtField().sendKeys(register.validPassword());
    }

    @And ("user clicks on register button")
    public void clickRegisterButton() {
        register.registerButton().click();
    }


    @Then("success message is displayed")
    public void user_could_register_successfully() {
        SoftAssert softAssert= new SoftAssert();
        String actualResult = register.successMsg().getText();
        String expectedResult = "Your registration completed";
        String MsgColor = register.successMsg().getCssValue("color");
        softAssert.assertEquals(actualResult,expectedResult);
        softAssert.assertEquals(MsgColor,"rgba(76, 177, 124, 1)");
        System.out.println("Color = " + MsgColor);
    }
}
