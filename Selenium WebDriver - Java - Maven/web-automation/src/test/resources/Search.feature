Feature: Web Automation

  Scenario: Search for "COMAR Assurances partenaire"
    Given I open the website "https://www.comar.tn/"
    When I click on the "Actualités" link
    Then I should see the "Actualités" section
    When I enter "COMAR Assurances partenaire" in the search box and submit
    Then I should see the text "COMAR Assurances partenaire du Semi-Marathon Ulysse Djerba"
