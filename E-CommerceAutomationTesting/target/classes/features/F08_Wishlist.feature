@smoke
  Feature: Check Wishlist Feature
    Scenario: check add to wishlist
      Given click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop
      When check success message and background color

    Scenario: check add to wishlist and wait until adding message then check wishlist and Qty
      Given click on wishlist button ❤️ on this product "HTC One M8 Android L 5.0 Lollipop
      When wait until message and background color disappear
      Then click on Wishlist Tab on the top of the page
      And get Qty value and verify it's bigger than 0

