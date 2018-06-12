@Smoke
Feature: Smoke test

  Scenario: Smoke test
    Given a user logs into Tiki Application, HomePage is displayed
    And a user verifies following menu options are displayed
      | Search         |
      | Categories     |
      | Tags           |
      | Calendar       |
      | Wiki           |
      | Articles       |
      | Blogs          |
      | Forums         |
      | File Galleries |
      | Spreadsheets   |
      | Trackers       |
      | Surveys        |
      | Newsletters    |
      | Settings       |
    And a user logs out
