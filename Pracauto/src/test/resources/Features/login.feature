Feature: this to login to the app

  @login
  Scenario Outline: login with valid informations
    Given User in login page
    When User enters <username> and <password>
    And User clicks on login
    Then Dashbord page should appear

    Examples: 
      | username                     | password  |
      | youssra.saadeedine@gmail.com | Yf212121@ |
