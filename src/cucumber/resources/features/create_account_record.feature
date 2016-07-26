Feature: Create account record

  Scenario: Add one account record
    Given there does not exist same record currently
    When create a valid record with date "2016-07-24" remark "remark" amount "12" amount_type "income"
    Then create succeed