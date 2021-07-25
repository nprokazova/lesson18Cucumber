Feature: Verifications for "otus.ru"

  Scenario Outline: Header title check
    Given The page "<name>" is opened
    When Checking that the title is not empty
    Then Header title check
    Examples:
      | name             |
      | https://otus.ru/ |

  Scenario Outline: Go to the "Contacts" tab and check the address
    Given The page "<name>" is opened
    When Go to the "Contacts" tab
    Then Checking that the address is correct
    Then Title check
    Examples:
      | name             |
      | https://otus.ru/ |

  Scenario Outline: checking the course program
    Given The page "<name>" is opened
    When Go to F.A.Q "<fqa>"
    When Click on the question: "Where can I see the program of the course of interest?"
    Then Text check
    Examples:
      | fqa                 | name             |
      | https://otus.ru/faq | https://otus.ru/ |

  Scenario Outline: Subscribe to news
    Given The page " <name>" is opened
    When Filling in a test mailbox in the "Subscribe to our news" field
    Then Clicking on the "Subscribe" button
    Then Checking the message: "You have successfully subscribed"
    Examples:
      | name             |
      | https://otus.ru/ |



