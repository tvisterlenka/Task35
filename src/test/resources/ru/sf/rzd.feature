Feature: Searching a ticket
#Positive scenario
  Scenario: enter correct data
    Given url of Russian Railways: 'https://www.rzd.ru/'
    When the site is open enter city name 'Москва' into the field From
    Then enter city name 'Урень' into the field To
    Then enter date '30.08.2023' into the field Depart
    And click the button Search
    Then assert that there is a list of results
#Negative scenario
  Scenario: enter no data
    Given url of Russian Railways: 'https://www.rzd.ru/'
    When the site is open click the button Search
    Then assert that user got the message 'Введите пункт отправления'