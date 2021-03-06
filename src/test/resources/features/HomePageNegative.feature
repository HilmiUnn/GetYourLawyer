@Negative @AllScenarios
Feature: QA Engineer test page testing Negative scenarios

  Background:
    Given the user navigates to URL
    And the user clicks "Click me" button
    And the user clicks "Now click me" button

  @TC8
  Scenario: Verify that it does not accept negative values or 0 value
    When the user enters zero or negative values
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user selects alternative option
    And the user clicks "Submit" button
    Then the user verifies it gives warning message to enter positive values

  @TC9
  Scenario Outline: Verify that if user enters "e" or "." it gives notification message
    When the user enters "<value>" as seed number
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user gets validation message
    Examples:
      | value |
      | e     |
      | .     |

  @TC10
  Scenario Outline: Verify that if user enters decimal values it gives notification message
    When the user enters "<decimal value>" as seed number
    And the user enters name
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user gets decimal value validation message
    Examples:
      | decimal value |
      | 115.7         |
      | 0.96          |


  @TC11
  Scenario Outline: Verify that name field don't accept number or symbol values
    And the user enters number of seeds by keyboard
    When the user enters "<not alphabetical values>"
    And the user selects any time to plant feeds
    And the user selects "ONE" tree type
    And the user clicks "Submit" button
    Then the user verifies that it gives warning message to enter valid format
    Examples:
      | not alphabetical values |
      | 123                     |
      | *                       |
      | $                       |
      | #                       |

  @TC12
  Scenario: Verify that user gets error message if time field is empty
    And the user enters number of seeds by keyboard
    And the user enters name
    And the user selects "ONE" tree type
    When the user clicks "Submit" button
    Then the user verifies that it gives warning message to enter time field

  @TC13
  Scenario:  Verify that user gets error message if tree type field is empty
    And the user enters number of seeds by keyboard
    And the user enters name
    And the user selects any time to plant feeds
    When the user clicks "Submit" button
    Then the user verifies that it gives warning message to enter tree type field

