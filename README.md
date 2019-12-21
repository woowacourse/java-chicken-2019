# java-chicken-2019

### made by chilbok_kim

--------

# Application.java
variables
- List<Table<ar>> tables : tables in chicken restaurant
- List<Menu<ar>> menus : menu list of this restaurant

methods
- parseTableNumberToIndex(int tableNumber, List<Table> tables) : parse Number to Index of table list

# view.OutputView
methods
- printTables(final List<Table<ar>> tables) : print all tables with order checker
- printCommandList() : print all commands
- printMenus(List<Menu<ar>> menus) : print all menu in menuRepository
- printTopLine(int count) : print top line
- printBottomLine(List<Table<ar>> tables) : print bottom line with order checking
- printTableNumbers(List<Table<ar>> tables) : print table numbers
- printReceipt(Table table) : print the table's receipt
- printTotalPrice(Table table, int methodOfPayment) : print the table's total price


# view.inputView
methods
- inputTableNumber()
- inputCommandList()
- inputMethodOfPayment() : ask user about user's payment
- intputMenuType() : input the type of menu
- inputMenuNumber() : input the amount of menu

# domain.Category
: information about menu's Category

# domain.Menu.java
variables
- int number
- String name
- Category category
- int price

methods
- Menu(int number, String name, Category category) : constructor
- toString() : override method
- getNumber() : return number
- getNmae() : return name
- getPrice() : return price


# domain.MenuRepository.java
methods
- List<Menu<ar>> menus() : return collections
- getMenuNameByIndex(int index) : return name by using index
- getMnuPriceByIndex(int index) : return price by using index

# domain.Table
variables
- number
- List<Menu<ar>> menus
- HashMap<String,Integer<ar>> orderedMenu : save table's order

methods
- toString() : override method
- getNumber() : return number
- sizess() : return size of orderedMenu
- isOrdered() : check ordered or not
- order() : order menu
- printReceipt() : print the ordered menus and price
- getMenuPrice(String menuName) : return menu's price
- calculateDiscount() : calculate the discounting money
- getTotalPrice(int methodOfPayment) : return total price of the table

# domain.TableRepository.java
DataBase of tables