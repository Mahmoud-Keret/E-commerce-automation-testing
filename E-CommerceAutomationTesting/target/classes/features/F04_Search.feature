@smoke
Feature:
  Scenario Outline: user could search using product name
Given enter product name in search field "<productName>"
When click on search button
Then check the URL product name search result
Examples:
| productName |
| book |
| laptop |
| nike |

Scenario Outline: user could search for product using sku
Given enter product Sku in search field "<productSku>"
When click on search button
Then check the product sku search result
Examples:
| productSku |
| SCI_FAITH |
| APPLE_CAM |
| SF_PRO_11 |


