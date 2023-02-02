Feature: US5 As a user Je souhaite Depuis la page My Account visualiser mes informations de compte Afin de Pouvoir gérer mon compte

  @detail
  Scenario: Go to Account details
    Given User in my account page
    When User clicks account details
    Then User is navigated to account details

  @passInvalid
  Scenario Outline: Change password with invalid password
    Given User in account details
    When detail enters <curpass> and <newpass> and confirm with <confpass>
    Then message of error is displayed

    Examples: 
      | curpass   | newpass   | confpass  |
      | Yk212121@ | Yn212121@ | Yn212121@ |

  @passValid
  Scenario Outline: Change password with valid password
    Given User in account details
    When detail enters <curpass> and <newpass> and confirm with <confpass>
    Then message of succes is displayed

    Examples: 
      | curpass   | newpass   | confpass  |
      | Yn212117@ | Yn212121@ | Yn212121@ |
