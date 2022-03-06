package com.getYourLawyer.pages;

import com.getYourLawyer.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
import static org.junit.Assert.*;

/**
    * This class includes all webElements and methods
    */

public class HomePage {

    /**
     * Used to initialize webElements
     */
    public HomePage() {PageFactory.initElements(Driver.get(), this);}


    @FindBy(id = "first")
    public WebElement clickMe;

    @FindBy(id = "second")
    public WebElement nowClickMe;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submit;

    @FindBy(name = "seeds")
    public WebElement seedsCount;

    @FindBy(name = "name")
    public WebElement nameField;

    @FindBy(name = "time")
    public WebElement timeField;

    @FindBy(xpath = "//select[@name='type']")
    public WebElement treeTypeOptions;

    @FindBy(xpath = "//form/p")
    public WebElement result;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement alternativeCheckBox;

    @FindBy(id = "errors")
    public WebElement errors;

    @FindBy(id = "form")
    public WebElement form;

    @FindBy(xpath = "//form/p")
    public WebElement resultForm;


    /**
     * This method generates random positive values to enter as seed amount.
     * It saves random value to verify on later steps
     */
    int value = 0;
    public void seedGenerator() {
        Random r = new Random();
        value = r.nextInt(10_000_000);
        seedsCount.sendKeys(String.valueOf(value));
    }

    /**
     * This method generates random negative values and also "0" value to enter as seed amount
     */
    public void negativeOrZeroSeedGenerator() {
        Random r = new Random();
        value = r.nextInt(1 + 10_000_000) - 10_000_000;
        seedsCount.sendKeys(String.valueOf(value));
    }

    /**
     * This method generates random names to enter name field.
     * It saves random name value to verify on later steps
     */
    String name = null;
    public void nameGenerator() {
        Faker faker = new Faker();
        name = faker.name().firstName().replaceAll("[^A-Za-z]", "")
                .concat(" ")
                .concat(faker.name().lastName().replaceAll("[^A-Za-z]", ""));
        nameField.sendKeys(name);

    }

    /**
     * This method used for clicking "Click me","Now click me" and "Submit" buttons
     * @param button
     */
    public void clickMethod(String button) {
        switch (button) {
            case "Click me":
                clickMe.click();
                break;
            case "Now click me":
                nowClickMe.click();
                break;
            case "Submit":
                submit.click();
        }
    }

    /**
     * This method used for selecting any time by using arrows
     */
    public void timeSelect(){
        timeField.sendKeys(Keys.SPACE);
        timeField.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
        timeField.sendKeys(Keys.ARROW_RIGHT);
        timeField.sendKeys(Keys.ARROW_DOWN);
        timeField.sendKeys(Keys.ARROW_RIGHT);
        timeField.sendKeys(Keys.ARROW_DOWN);
    }

    /**
     * This method used for the selecting tree type
     * and also this method used for getting this value as an int to use at verify steps
     */
    int typeValue = 0;
    public void treeType(String type) {
        Select select = new Select(treeTypeOptions);

        switch (type.toLowerCase()) {
            case "one":
                select.selectByValue("1");
                typeValue = 1;
                break;
            case "two":
                select.selectByValue("2");
                typeValue = 2;
                break;
            case "three":
                select.selectByValue("3");
                typeValue = 3;
                break;
            default:
                System.out.println("Please enter One,Two or Three ");
        }
    }


    /**
     * This method used to select Alternative calculation method
     * And ıt saves check/uncheck option as boolean to use at verify steps
     */
    boolean flag = false;
    public void clickCheckBox() {
        alternativeCheckBox.click();
        flag = alternativeCheckBox.isSelected();
    }

    /**
     * This method used for verifying the calculation result
     * It will calculate result based on the Alternative calculation method selection option
     * And verifies with result
     */
    public void verifyResult() {
        String expectedResult;
        if (flag) {
            expectedResult = Integer.toString(value / 5 * typeValue);
        } else {
            expectedResult = Integer.toString(value / 10 * typeValue);
        }
        assertTrue(result.getText().contains(expectedResult));
    }

    /**
     * This method used for verifying username
     * It will get name from result page and verify with randomly created name
     */
    public void verifyName() {
        String actualName = result.getText().split(", ")[1].split("!")[0];
        assertEquals("Name is not matching", actualName, name);
    }


    /**
     * This method is used to get and verify validation message,
     * (which only is got when the user uses "e" and "." values as seed numbers)
     */
    public void validationMessage(){
        String validationMessage = seedsCount.getAttribute("validationMessage");
        String expectedValidationMessage="Please enter a number.";
        assertEquals(validationMessage,expectedValidationMessage);
    }

    /**
     * This method used for verifying arrow buttons function
     * It gets pushed arrow direction and push count
     * After entering any value this method generate arrow functions as selected direction and count.
     * Then it will verify function and count by subtracting new value from previous value
     *
     * @param arrow
     * @param count
     */

    public void upDownArrows(String arrow, int count) {
        int newValue;

        switch (arrow.toLowerCase()) {

            case "up":
                for (int i = 0; i < count; i++) {
                    seedsCount.sendKeys(Keys.ARROW_UP);
                }
                newValue = Integer.parseInt(seedsCount.getAttribute("value"));
                assertEquals((newValue - value), count);
                value = newValue;
                break;

            case "down":
                for (int i = 0; i < count; i++) {
                    seedsCount.sendKeys(Keys.ARROW_DOWN);
                }
                newValue = Integer.parseInt(seedsCount.getAttribute("value"));
                assertEquals((value - newValue), count);
                value = newValue;
            default:
                System.out.println("Please enter Up or Down");
        }
    }

}
