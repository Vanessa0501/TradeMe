Feature:Write scenarios for the login page

  @Motors
  Scenario: Check there is at least one listing in the TradeMe UsedCars category
    Given I am on Trade Me Motors page
    When I click on Cars for sale link
    Then I should see used cars listing

  @Motors
 Scenario: Check that the make ‘Kia’ exists
    Given I am on Trade Me Motors page
    When I click on Cars for sale link
    Then I can see 'Kia' car make exists

  @Motors
  Scenario Outline: Query any existing Used Car listing and verify the correct details are displayed
    Given I am on Trade Me Motors page
    When I click on Cars for sale link
    And I select the first car listing
    And the car has the following details "<numberplate>" and "<kilometres>" and "<body>" and "<seat>" and "<fueltype>" and "<engine>" and "<transmission>" and "<history>" and "<registrationexpires>" and "<wofexpires>" and "<modeldetail>"
    Examples:
       |numberplate|kilometres|body                    |seat|fueltype|engine|transmission|history        |registrationexpires|wofexpires|modeldetail |
       |KAA294     |103,114km |White, 5 door, Hatchback|n/a |Petrol  |1998cc|Automatic   |1 owner, NZ New|Nov 2020           |Nov 2020  |Compact Disc|







