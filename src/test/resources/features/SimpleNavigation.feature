Feature:  Simple Navigation

  Scenario:  Navigating to Barclays
    Given I have a browser open
    When  I navigate to "https://home.barclays/"
    Then I see the "Barclays" page


  Scenario Outline: More navigation tests
    Given I have a browser open
    When  I navigate to <url_address>
    Then I see the <page_title> page

    Examples:
      | url_address                  | page_title  |
      | "http://www.fairfieldco.com" | "Fairfield" |
      | "http://www.google.com"      | "Google"    |