Feature: Create account

  Scenario: Add a new account
    Given there is no same account
    When create a valid account with account_name "default_account" balance 1000
    Then display the account information with above name and balance