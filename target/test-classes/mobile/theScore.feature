@Test
Feature: theScore Leagues Page Navigation

  Scenario: Login to theScore app and navigate through League tabs
    Given user is on the Welcome Page
    When user taps on the Log In button
    And enters valid credentials to log in
    Then it takes user to Home Page
    When user selects Leagues
    And user selects Spain Soccer from the Leagues
    Then Spain Soccer League title should be displayed
    And user selects Table sub-tab
    Then table subtitle should be displayed
    When user taps on back navigation
    Then previous page is displayed

