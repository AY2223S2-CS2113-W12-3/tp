# User Guide
![img_11.png](img_11.png)
## Contents
- [Introduction](#introduction-)
- [Quick Start](#quick-start-)
- [Features](#features)
- [FAQ](#faq)
- [Command Summary](#command-summary)

## Introduction

MagusStock is a Java command-line interface (CLI) application designed for inventory management.

## Quick Start

1. Ensure that you have Java 11 or above installed. 
2. Download the latest version of MagusStock from [here](https://github.com/AY2223S2-CS2113-W12-3/tp/releases).
3. Move the `.jar` file to an empty folder.
4. Run the file with the command `java -jar magusstock.jar`.

## Features
- [Adding an item: `add`](#adding-an-item-add-)
- [Editing an item: `edit`](#editing-an-item-edit-)
- [Removing an item: `remove`](#removing-an-item-remove-)
- [Listing all items: `list`](#list-all-items-list)
- [Searching for item(s): `search`](#search-for-an-item-search-searchupc)
- [Filtering item(s) by type: `filter`](#filtering-items-filter)
- [Listing all commands: `help`](#list-all-available-commands-help)
- [History of item: `history`](#historical-records-of-item-history-)
- [Selling an item: `sell`](#sell-quantity-of-item-sell-)
- [Restocking an item: `restock`](#restock-an-item-restock-)
- [Dashboard: `db`](#dashboard-db-)
- [Category: `cat`](#category-cat-)
- [Alert for item(s): `alert`](#alert-for-an-item-alert-)
- [Autosave of Inventory: `autosave`](#change-autosave-mode-autosave-)
- [Exiting the program: `exit`](#exiting-the-program-exit-)

---
### Adding an item: `add` <a name = "add"></a>
Adds a new item to the inventory list.

Format: `add n/[item_name] upc/[UPC] qty/[quantity] p/[price] c/[category]`

**REQUIRED** parameters:
* The `n/` parameter where `[item_name]`  must be alphanumeric. 
* The `upc/` parameter for `[UPC]` must be a **non-negative numerical** value.
* The `qty/` parameter for `[quantity]` must be a **non-negative numerical** value.
* The `p/` parameter for `[price]` must be a **non-negative numerical** value _(decimals accepted)_.

**OPTIONAL** parameters:
* The `c/` parameter for `[category]` must be alphanumeric. (Defaults to: `Uncategorized` if not specified.)

Example of usage: 
=======


!> **Enforced** valid range for numerical parameters is **0** to **999999999**.


#### Example of usage

`add n/HP Laptop upc/2142535453 qty/10 p/1299.99`

`add n/iPhone 11 Pro Max Max upc/2987654323 qty/11 p/1099.99 c/electronics`

#### Sample output
```
add n/iPhone 11 Pro Max Max upc/2987654323 qty/11 p/1099.99 c/electronics
____________________________________________________________
Successfully added the item(s) into the system!
____________________________________________________________
```
---
### Editing an item: `edit` <a name = "edit"></a>
Edit an item's details in the inventory.


Format: `edit upc/[UPC] n/[item_name] qty/[quantity] p/[price] c/[category]`


**REQUIRED** parameters:
* The `upc/` parameter where `[UPC]`  must be a numerical value and exists in the inventory.

**OPTIONAL** parameters:
* The `n/` parameter where `[item_name]` must be alphanumeric.
* The `qty/` parameter for `[quantity]` must be a **non-negative numerical** value.
* The `p/` parameter for `[price]` must be a **non-negative numerical value** (decimals accepted).
* The `c/` parameter for `[category]` must be alphanumeric.

!> **Enforced** valid range for numerical parameters is **0** to **99,999,999**.

#### Example of usage

`edit upc/2142535453 c/laptop`: Searches for the item in the inventory with a `UPC` code of `2142535453`, and change
its `Category` type to `laptop`. <br />

`edit upc/123 n/Orange qty/5 p/2.00`: Searches for the item in the inventory with a `UPC` code of `123`, and change
its `Name` to `Orange`, `quantity` to be set to `5` and `price` will be set to `2.00`.

#### Sample output
```
edit upc/2142535453 c/laptop
____________________________________________________________
Successfully edited the following item:

Before Update: 
Name: HP Laptop Pro
UPC: 2142535453
Price: 1299.99
Quantity: 10
Category: uncategorised

After Update: 
Name: HP Laptop Pro
UPC: 2142535453
Price: 1299.99
Quantity: 10
Category: laptop
____________________________________________________________

```
---
### Removing an item: `remove` <a name = "remove"></a>
Removes an item from the inventory list using either its UPC or index in list.

Format: `remove f/item upc/[UPC]` or `remove f/index [Index]`

**REQUIRED** parameters:

* The `UPC` can be only be a numerical value.
* The `index` can only be a number.

!> **index** follows 0-indexing. (i.e. The first item in the list is at index 0.)

#### Example of usage

`remove f/item upc/123456789`

`remove f/index 0`

#### Sample output

---
### List all items: `list` 
Lists all items in the inventory list.

Format: `list`

#### Example of usage

`list`

#### Sample output 
**Case I:** When there are items in the inventory

```
list
____________________________________________________________

██╗███╗░░██╗██╗░░░██╗███████╗███╗░░██╗████████╗░█████╗░██████╗░██╗░░░██╗
██║████╗░██║██║░░░██║██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔══██╗╚██╗░██╔╝
██║██╔██╗██║╚██╗░██╔╝█████╗░░██╔██╗██║░░░██║░░░██║░░██║██████╔╝░╚████╔╝░
██║██║╚████║░╚████╔╝░██╔══╝░░██║╚████║░░░██║░░░██║░░██║██╔══██╗░░╚██╔╝░░
██║██║░╚███║░░╚██╔╝░░███████╗██║░╚███║░░░██║░░░╚█████╔╝██║░░██║░░░██║░░░
╚═╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░
Here are the items in your inventory:
+-----------------+--------------+----------+----------+
| Name            | UPC          | Quantity | Price    |
+-----------------+--------------+----------+----------+
| laptop          | 12           | 33       | $2.3     |
+-----------------+--------------+----------+----------+
| laptop sleeves  | 1212         | 33       | $2.4     |
+-----------------+--------------+----------+----------+

____________________________________________________________

```

**Case II:** When there is no items in the inventory
```
list
____________________________________________________________
There are no items in your inventory.
____________________________________________________________
```
---
### Search for an item: `search` / `searchupc`
Search for item(s) in the inventory list by keywords or UPC.

| Format | Required parameter |
| --- | --- |
| `search [Keywords]` | `[Keywords]` can be an alphanumerical value. |
| `searchupc [UPC]` | `[UPC]` can only be a **non-negative numerical** value. |


!> Note: `search` will find items with all keywords. Hence, the search term `sleeves` will find both `Laptop Sleeves`
and `Clothes Sleeves`, but the search term `laptop slee` will only return the item `Laptop Sleeves`

#### Example of usage:

`search laptop slee` or `searchupc 0123241`

#### Sample output:


**Case I:** Search by keywords
```
search laptop slee
____________________________________________________________
+-----------------+--------------+----------+----------+
| Name            | UPC          | Quantity | Price    |
+-----------------+--------------+----------+----------+
| laptop sleeves  | 1            | 10       | $15.0    |
+-----------------+--------------+----------+----------+

____________________________________________________________
```
**Case II:** Search by UPC

```
searchupc 0123241
____________________________________________________________
Here is your item: 
+-----------------+--------------+----------+----------+
| Name            | UPC          | Quantity | Price    |
+-----------------+--------------+----------+----------+
| Apples          | 0123241      | 10       | $15.0    |
+-----------------+--------------+----------+----------+

____________________________________________________________
```
---
### Filtering items: `filter`


Filters items from the inventory list by price OR category.


| Filter By | Format              | Required parameter                                  |
|-----------|---------------------|-----------------------------------------------------|
| Price     | `filter f/price`    | `p/gt`/`p/get`/`p/lt`/`p/let` followed by `[price]` |
| Category  | `filter f/category` | `[Category keywords]`                               |


**REQUIRED** parameters:
* For `filter f/price`, the `[price]` parameter must be a **non-negative numerical value** within a valid range
* For `filter f/category`, the `[Category keywords]` parameter must be an **alphanumerical value**.


!> **Enforced** valid range for numerical parameters is **0** to **999999999**.


| Price Comparator | Required parameter                     |
|------------------|----------------------------------------|
| `p/gt`           | Items price greater than `[price]`     |
| `p/get`          | Items price greater/equals to`[price]` |
| `p/lt`           | Items price less than `[price]`        |
| `p/let`          | Items price lesser/equals to `[price]` |



#### Example of usage:

`filter f/category fruits` or `filter f/price p/gt 10.2`

#### Sample output:

**Case I:** Filter by category

```
filter f/category fruits
+-----------------+--------------+----------+----------+
| Name            | UPC          | Quantity | Price    |
+-----------------+--------------+----------+----------+
| Apples          | 0123241      | 10       | $15.0    |
+-----------------+--------------+----------+----------+
| Large Apples    | 012321       | 10       | $15.0    |
+-----------------+--------------+----------+----------+

____________________________________________________________
```

**Case II:** Filter by price

```
filter f/price p/gt 10.2
____________________________________________________________
+-----------------+--------------+----------+----------+
| Name            | UPC          | Quantity | Price    |
+-----------------+--------------+----------+----------+
| TV              | 1            | 1        | $10999.0 |
+-----------------+--------------+----------+----------+
| Apples          | 0123241      | 10       | $15.0    |
+-----------------+--------------+----------+----------+
| Large Apples    | 012321       | 10       | $15.0    |
+-----------------+--------------+----------+----------+

____________________________________________________________

```
---
### List all available commands: `help`
Lists all commands available and the command formats.

Format: `help`

#### Example of usage

`help`

#### Sample output
```agsl
_________________________________________________________
help
+---------------------------+---------------------------+
| Command                   | Command Format            |
+---------------------------+---------------------------+
| history: shows the        | history UPC               |
| historical commands       |                           |
| executed for an item      |                           |
+---------------------------+---------------------------+
.........INTENTIONALLY TRUNCATED FOR DEMOSTRATION........
+---------------------------+---------------------------+
| db: Displays the          | db                        |
| dashboard of Magus-Stock  |                           |
+---------------------------+---------------------------+
```


---
### Historical records of item: `history` <a name = "history"></a>
Lists historical changes to an item in the inventory list.

Format: `history [UPC]`

#### Example of usage

``history 0123241``

#### Sample output


```
____________________________________________________________
Item added at: 12:00 AM, WEDNESDAY, MARCH 29, 2023
Name: Apples
UPC: 0123241
Price: 15.0
Quantity: 10
Category: uncategorized
____________________________________________________________
____________________________________________________________
At: 12:04 AM, WEDNESDAY, MARCH 29, 2023
Category changed to: fruits
____________________________________________________________
____________________________________________________________
At: 12:06 AM, WEDNESDAY, MARCH 29, 2023
Sold 5 items
____________________________________________________________
____________________________________________________________
At: 12:06 AM, WEDNESDAY, MARCH 29, 2023
Bought 50 items
____________________________________________________________
____________________________________________________________
At: 12:06 AM, WEDNESDAY, MARCH 29, 2023
Price decreased from $15.0 to $5.0
____________________________________________________________
____________________________________________________________
Name: Apples
UPC: 0123241
Price: 5.0
Quantity: 55
Category: fruits
____________________________________________________________
```

---
### Sell quantity of item: `sell` <a name = "sell"></a>
Reduces the quantity of an item in the inventory list.

Format: `sell upc/[UPC] qty/[Quantity]`

**REQUIRED** Parameters:

* The `upc/` parameter whereby `[UPC]` refers to the identification number assigned to the item at the point 
of **initial addition** of the item. `[UPC]` has to be valid, that is, it **EXISTS** in the database, and has to be 
a **POSITIVE NUMBER** and **NOT EMPTY**. Do **NOT** include `[` and `]` in the input.
* The `qty/` parameter whereby `[Quantity]` refers to the amount of stock to be **DEDUCTED** from the current 
stock levels recorded. `[Quantity]` input **SHOULD NOT** be **EMPTY**,a **NEGATIVE INTEGER**, **ZERO** or a **STRING**. 
Do **NOT** include `[` and `]` in the input.

!> **Enforced** valid `[Quantity]` input range to be from **1** up to the **Current Quantity Level** of the item,
provided that the **Current Quantity Level** is **NOT ZERO**.

Example of Usage: <br />
`sell upc/123 qty/5`: Searches for the item of `UPC` code `123`, and if it exists, **DEDUCT** a `quantity` of `5`
items from its current stock levels, provided that the total quantity after selling does not go below 0.

`sell upc/987612345 qty/10`: Searches for the item of `UPC` code `987612345`, and if it exists, **DEDUCT** a 
`quantity` of `10` items from its current stock levels. provided that the total quantity after selling does not go
below 0.

Sample output:
````
____________________________________________________________
sell upc/123 qty/5
____________________________________________________________
Successfully sold the following item:

Before Selling: 
Item Name: orange and apples
UPC Code: 123
Quantity Available: 10

After Selling: 
Item Name: orange and apples
UPC Code: 123
Quantity Available: 5

Sold 5 orange and apples at a price of $6.0.
____________________________________________________________
````

---
### Restock an item: `restock` <a name = "restock"></a>
Restock quantities of an item in the inventory list.

Format: `restock upc/[UPC] qty/[Quantity]`

**Required** Parameters:
* The `upc/` parameter  whereby `[UPC]` refers to the identification number assigned to the item at the point of 
**initial addition** of the item. `[UPC]` has to be valid, that is, it **EXISTS** in the database, and has to be
a **POSITIVE NUMBER** and **NOT EMPTY**. Do **NOT** include `[` and `]` in the input.
* The `qty/` parameter whereby `[Quantity]` refers to the amount of stock to be **ADDED** from the current stock 
levels recorded. `[Quantity]` input **SHOULD NOT** be **EMPTY**,a **NEGATIVE INTEGER**, **ZERO** or a **STRING**. 
Do **NOT** include `[` and `]` in the input.

!> **Enforced** valid `[Quantity]` input range to be from **1** to **99,999,999**. Ensure that the post-restock 
quantity does not add up to above 99,999,999.

Example of Usage: <br />
`restock upc/12345 qty/5`: Searches for the item of `UPC` code `12345`, and if it exists, **ADD** a `quantity` of `5`
items to its current stock levels, provided that the total quantity after restocking does **not** exceed 99,999,999.

`restock upc/999 qty/10`: Searches for the item of `UPC` code `999`, and if it exists, **ADD** a
`quantity` of `10` items to its current stock levels, provided that the total quantity after restocking does **not**
exceed 99,999,999.

Sample output:
```
____________________________________________________________
restock upc/12345 qty/5
____________________________________________________________
Successfully restocked the following item:

Before Restocking:
Item Name: Computer
UPC Code: 12345
Quantity Available: 100

After Restocking:
Item Name: Computer
UPC Code: 12345
Quantity Available: 105
____________________________________________________________
```

---
### Dashboard: `db` <a name = "db"></a>
Shows a dashboard of information related to the system's inventory, user insights and 
session configurations.

Format: `db`

**Required** Parameters:
* The `db` command keyword, which should **NOT** contain any further user inputs after typing it. 

Example of usage: <br />
`db`: Opens the dashboard.

Sample output
```
db
____________________________________________________________

██████╗░░█████╗░░██████╗██╗░░██╗██████╗░░█████╗░░█████╗░██████╗░██████╗░
██╔══██╗██╔══██╗██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗
██║░░██║███████║╚█████╗░███████║██████╦╝██║░░██║███████║██████╔╝██║░░██║
██║░░██║██╔══██║░╚═══██╗██╔══██║██╔══██╗██║░░██║██╔══██║██╔══██╗██║░░██║
██████╔╝██║░░██║██████╔╝██║░░██║██████╦╝╚█████╔╝██║░░██║██║░░██║██████╔╝
╚═════╝░╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░
Overview:
____________________________________________________________
Total number of items: 2
Total number of active alerts: 0
Total value of inventory: $155.1
Item with most quantity: laptop (33)
Item with least quantity: laptop (33)
____________________________________________________________
Current Session Configurations:
____________________________________________________________
AutoSave Mode: TRUE
Inventory Data File Status: CORRUPTED
Alerts Data File Status: MISSING (Will be created if AutoSave is TRUE)
____________________________________________________________
List of active alerts:
No alerts to print.
____________________________________________________________
```

---
### Category: `cat` <a name = "cat"></a>
Shows list of categories, and/or its items, or a specified category of items.

Format: 
`cat list`shows list of all categories in the inventory.
* `cat table`: shows table of all categories and all items in each category.

Example of Usage & Expected Output:
```
cat list
____________________________________________________________
Here is the list of categories you have: 
uncategorized
fruits
____________________________________________________________
```
```
cat table
+-----------------+--------------------------------+
| Category        | Name: UPC                      |
+-----------------+--------------------------------+
| uncategorized   | testItem:123456789012,         |
|                 | testItem2:123456789013,        |
|                 | asdsadsa:1231                  |
+-----------------+--------------------------------+
```

### Alert for an item: `alert` <a name = "alert"></a>
Add alerts that will display when the quantity of an item falls below a set minimum or exceeds a maximum level.

Format:  
`alert add upc/{upc} min/{quantity} ` to set an alert when quantity falls below a minimum  
`alert add upc/{upc} max/{quantity}` to set an alert when quantity exceeds a maximum  
`alert remove upc/{upc} level/min` to remove an alert for the minimum quantity of an item  
`alert remove upc/{upc} level/max` to remove an alert for the maximum quantity of an item  

Examples of usage:  
`alert add upc/1234 min/55`  
`alert add upc/1234 max/100`

Sample output:
```
____________________________________________________________
Successfully added a new alert.
____________________________________________________________
```

Examples of usage: 
`alert remove upc/1234 level/min`  
`alert remove upc/1234 level/max`


Sample output
```
____________________________________________________________
Successfully removed the alert.
____________________________________________________________
``` 

---
### Change Autosave Mode: `autosave` <a name = "autosave"></a>

Set whether the program should automatically save the updated inventory to the inventory data file after every successful
write command issued.

Note: if autosave is disabled, the program will not save on exit. This is because autosave off functions similarly to 
incognito mode on a browser.

Format: `autosave [on/off]`

Sample input and expected output:
```
autosave on
____________________________________________________________
Auto-save has been enabled!
____________________________________________________________
```

```
autosave off
____________________________________________________________
Auto-save has been disabled!
____________________________________________________________
```

---
### Exiting the program: `exit` <a name = "exit"></a>
Exits the MagusStock program.

Format: `exit` or `bye`

Sample output:
```
____________________________________________________________
Hope you had an enjoyable experience. See you next time!
____________________________________________________________
```

---

<a name = "faq"></a>
<a name = "command_summary"></a>
## Command Summary
| Action                          |
|---------------------------------|
| Add item (`add`)                |
| Remove item (`remove`)          |
| Edit item (`edit`)              |
| List all items (`list`)         |
| Search items (`search`)         |
| Filter items (`filter`)         |
| Sell items (`sell`)             |
| Restock items (`restock`)       |
| Add and remove alerts (`alert`) |
| View item categories (`cat`)    |
| View history (`history`)        |
| View dashboard (`db`) |
| View all commands (`help`) |
| Set autosave mode (`autosave`) |
| Exit the program (`exit`) |


