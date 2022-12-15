@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user opens facebook link
  Given user opens facebook link
  When "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
  Given user opens twitter link
  When "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
  Given user opens rss link
  When "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user opens youtube link
  Given user opens youtube link
  When "https://www.youtube.com/user/nopCommerce" is opened in new tab
