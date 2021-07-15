Feature: Buying three products on the page opencart.abstracta.us

    @buy-product
    Scenario Outline: Buying three products
        Given go to the website
        When the user "<test_case>" sign in on page
        And buying two laptops and a camera
        And the user records more details "<test_case>"
        Then the order is registered

        Examples:
        | test_case |
        | 1         |
