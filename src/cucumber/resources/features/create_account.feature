Feature: Create account

  Scenario: Add a new account
    Given there is no same account
    When create a valid account with account_name "default_account" balance 1000
    Then the account information will be saved as name "default_account" balance 1000