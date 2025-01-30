Feature: MoneyGaming Registration - Password Validation

  As a new MoneyGaming player
  I want to register with a valid password
  So that I can securely access my account and play online casino games

  Scenario Outline: Register with a valid password
    Given I am on the MoneyGaming registration page
    When I enter a valid title "<title>"
    And I enter a valid first name "<first_name>"
    And I enter a valid surname "<surname>"
    And I enter a valid date of birth "<dob>"
    And I enter a valid password "<password>"
    And I accept the Terms and Conditions
    And I submit the registration form
    Then I should be successfully registered

    Examples:
      | title | first_name | surname    | dob        | password      |
      | Mr    | Vasil      | Merdzhanov | 01/01/1990 | Passw0rd!     |
      | Mrs   | Daniela    | Pey        | 15/05/1985 | Secure123@    |
      | Ms    | Jivka      | Boncheva   | 30/11/1995 | Test$2023     |

  Scenario Outline: Register with an invalid password
    Given I am on the MoneyGaming registration page
    When I enter a valid title "<title>"
    And I enter a valid first name "<first_name>"
    And I enter a valid surname "<surname>"
    And I enter a valid date of birth "<dob>"
    And I enter an invalid password "<password>"
    And I accept the Terms and Conditions
    And I submit the registration form
    Then I should see an error message "<error_message>"

    Examples:
      | title | first_name | surname  | dob        | password   | error_message                                        |
      | Mr    | Vasil      | Dobrev   | 01/01/1990 | pass       | Password must be at least 6 characters long          |
      | Mrs   | Vasilka    | Smith    | 15/05/1985 | Password   | Password must contain at least one number            |
      | Ms    |Dima        | Toshkova | 30/11/1995 | Password1  | Password must contain at least one special character |
      | Mr    | Grigor     | Dimov    | 01/01/1990 | 123456     | Password must contain at least one special character |
      | Mrs   | Petq       | Stoikova | 15/05/1985 | !@$%^      | Password must contain at least one number            |

  Scenario: Register without entering a password
    Given I am on the MoneyGaming registration page
    When I enter a valid title "Mr"
    And I enter a valid first name "Vasil"
    And I enter a valid surname "Merdzhanov"
    And I enter a valid date of birth "01/01/1990"
    And I leave the password field empty
    And I accept the Terms and Conditions
    And I submit the registration form
    Then I should see an error message "This field is required"