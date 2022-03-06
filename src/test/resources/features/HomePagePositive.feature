@Positive
Feature: QA Engineer test page testing Positive scenarios
  Background:
    Given the user navigates to URL
    And the user clicks "Click me" button

  @TC1
  Scenario: Verify that default calculation method calculates correct value
    And the user clicks "Now click me" button
    When the user enters number of seeds by keyboard
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user verifies the result and name

  @TC2
  Scenario:  Verify that alternative calculation method calculates correct value
    And the user clicks "Now click me" button
    When the user enters number of seeds by keyboard
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user selects alternative option
    And the user clicks "Submit" button
    Then the user verifies the result and name

  @TC3
  Scenario: Verify that "Now click me" button is visible after clicking on "Click me" button
    Then the user verifies Now click me button is visible

  @TC4
  Scenario: Verify that "Calculation Form" is visible after clicking on "Now click me" button
    When the user clicks "Now click me" button
    Then the user verifies Calculation Form is visible

  @TC5
  Scenario: Verify that "Now Click me" button appears after clicking "Click me"
    Then the user verifies that Now Click me button is appeared

  @TC6
  Scenario: Verify that user can set values by Up arrow
    And the user clicks "Now click me" button
    And the user enters number of seeds by keyboard
    When the user clicks "Up" arrow 10 times
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user verifies the result and name

  @TC7
  Scenario: Verify that user can set values by Down arrow
    And the user clicks "Now click me" button
    And the user enters number of seeds by keyboard
    When the user clicks "Down" arrow 15 times
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user verifies the result and name

  @TC8
  Scenario: Verify that back button does not open calculation form again
    And the user clicks "Now click me" button
    When the user enters number of seeds by keyboard
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    When the user clicks back arrow of window
    Then the user verifies that the form page is not reopened

  @TC9
  Scenario: Verify that refresh button opens home page
    And the user clicks "Now click me" button
    When the user enters number of seeds by keyboard
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    When the user clicks refresh button of window
    Then the user verifies that the home page is reopened