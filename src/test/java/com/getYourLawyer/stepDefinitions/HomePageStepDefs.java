package com.getYourLawyer.stepDefinitions;

import com.getYourLawyer.pages.HomePage;
import com.getYourLawyer.utilities.ConfigurationReader;
import com.getYourLawyer.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class HomePageStepDefs {
    HomePage homePage = new HomePage();

    @Given("the user navigates to URL")
    public void the_user_navigates_to_URL() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @Given("the user clicks {string} button")
    public void the_user_clicks_button(String Button) {
        homePage.clickMethod(Button);
    }


    @Then("the user enters number of seeds by keyboard")
    public void the_user_enters_number_of_seeds_by_keyboard() {
        homePage.seedGenerator();
    }


    @Then("the user enters name")
    public void the_user_enters_name() {
        homePage.nameGenerator();
    }


    @And("the user selects any time to plant feeds")
    public void theUserSelectsAnyTimeToPlantFeeds() {
        homePage.timeSelect();
    }


    @And("the user selects {string} tree type")
    public void theUserSelectsTreeType(String tree) {
        homePage.treeType(tree);
    }


    @Then("the user verifies the result and name")
    public void theUserVerifiesTheResultAndName() {
        homePage.verifyName();
        homePage.verifyResult();
    }


    @And("the user selects alternative option")
    public void theUserSelectsAlternativeOption() {
        homePage.clickCheckBox();
    }


    @Then("the user verifies Now click me button is visible")
    public void theUserVerifiesNowClickMeButtonIsVisible() {
        assertTrue("Now click me button is not visible", homePage.nowClickMe.isDisplayed());
    }


    @Then("the user verifies Calculation Form is visible")
    public void theUserVerifiesCalculationFormIsVisible() {
        assertTrue("Form is not visible", homePage.form.isDisplayed());
    }


    @When("the user enters zero or negative values")
    public void theUserEntersZeroOrNegativeValues() {
        homePage.negativeOrZeroSeedGenerator();
    }


    @Then("the user verifies it gives warning message to enter positive values")
    public void theUserVerifiesItGivesWarningMessageToEnterPositiveValues() {
        assertTrue(homePage.errors.getText().contains("The seeds must be at least 1."));
    }


    @When("the user enters {string} as seed number")
    public void theUserEntersAsSeedNumber(String wrongValue) {
        homePage.seedsCount.sendKeys(wrongValue);
    }


    @Then("the user gets validation message")
    public void theUserGetsValidationMessage() {
        homePage.validationMessage();
    }


    @When("the user clicks {string} arrow {int} times")
    public void theUserClicksArrowTimes(String arrow, int count) {
        homePage.upDownArrows(arrow, count);
    }


    @When("the user enters {string}")
    public void theUserEnters(String notSupportedValues) {
        homePage.nameField.sendKeys(notSupportedValues);
    }


    @Then("the user verifies that it gives warning message to enter valid format")
    public void theUserVerifiesThatItGivesWarningMessageToEnterValidFormat() {
        assertTrue(homePage.errors.getText().contains("The name format is invalid."));
    }


    @Then("the user verifies that it gives warning message to enter time field")
    public void theUserVerifiesThatItGivesWarningMessageToEnterTimeField() {
        assertTrue(homePage.errors.getText().contains("The time field is required."));
    }


    @Then("the user verifies that it gives warning message to enter tree type field")
    public void theUserVerifiesThatItGivesWarningMessageToEnterTreeTypeField() {
        assertTrue(homePage.errors.getText().contains("The type field is required."));
    }


    @When("the user clicks back arrow of window")
    public void theUserClicksBackArrowOfWindow() {
        Driver.get().navigate().back();
    }


    @Then("the user verifies that the form page is not reopened")
    public void theUserVerifiesThatTheFormPageIsNotReopened() {
        assertTrue(homePage.resultForm.isDisplayed());
    }


    @When("the user clicks refresh button of window")
    public void theUserClicksRefreshButtonOfWindow() {
        Driver.get().navigate().refresh();
    }


    @Then("the user verifies that the home page is reopened")
    public void theUserVerifiesThatTheHomePageIsReopened() {
        assertTrue(homePage.clickMe.isDisplayed());
        assertFalse(homePage.form.isDisplayed());
    }


    @And("the user verifies Click me button is visible")
    public void theUserVerifiesClickMeButtonIsVisible() {
        assertTrue("Click me button is not visible", homePage.clickMe.isDisplayed());
    }


    @And("the user verifies seeds number field is visible")
    public void theUserVerifiesSeedsNumberFieldIsVisible() {
        assertTrue("Seeds number field is not visible", homePage.seedsCount.isDisplayed());
    }


    @And("the user verifies name field is visible")
    public void theUserVerifiesNameFieldIsVisible() {
        assertTrue("Name field is not visible", homePage.nameField.isDisplayed());
    }


    @And("the user verifies time field is visible")
    public void theUserVerifiesTimeFieldIsVisible() {
        assertTrue("Time field is not visible", homePage.timeField.isDisplayed());
    }


    @And("the user verifies tree type field is visible")
    public void theUserVerifiesTreeTypeFieldIsVisible() {
        assertTrue("Tree type field is not visible", homePage.treeTypeOptions.isDisplayed());
    }


    @And("the user verifies alternative calculation checkbox is visible")
    public void theUserVerifiesAlternativeCalculationCheckboxIsVisible() {
        assertTrue("Alternative checkbox is not visible", homePage.alternativeCheckBox.isDisplayed());
    }
}
