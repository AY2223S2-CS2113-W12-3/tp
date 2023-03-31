package seedu.duke.utils;

import seedu.duke.exceptions.EditErrorException;
import seedu.duke.objects.AlertList;
import seedu.duke.objects.Inventory;
import seedu.duke.objects.Item;
import seedu.duke.types.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static seedu.duke.utils.ColorCode.ANSI_BLUE;
import static seedu.duke.utils.ColorCode.ANSI_CYAN;
import static seedu.duke.utils.ColorCode.ANSI_GREEN;
import static seedu.duke.utils.ColorCode.ANSI_ORANGE;
import static seedu.duke.utils.ColorCode.ANSI_RED;
import static seedu.duke.utils.ColorCode.ANSI_RESET;
import static seedu.duke.utils.ColorCode.ANSI_WHITE;
import static seedu.duke.utils.ColorCode.ANSI_YELLOW;

public class Ui {
    public static final String LINE = "____________________________________________________________";

    public static final String LOGO =
            "███╗░░░███╗░█████╗░░██████╗░██╗░░░██╗░██████╗░██████╗████████╗░█████╗░░█████╗░██╗░░██╗\n" +
                    "████╗░████║██╔══██╗██╔════╝░██║░░░██║██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██║░██╔╝\n" +
                    "██╔████╔██║███████║██║░░██╗░██║░░░██║╚█████╗░╚█████╗░░░░██║░░░██║░░██║██║░░╚═╝█████═╝░\n" +
                    "██║╚██╔╝██║██╔══██║██║░░╚██╗██║░░░██║░╚═══██╗░╚═══██╗░░░██║░░░██║░░██║██║░░██╗██╔═██╗░\n" +
                    "██║░╚═╝░██║██║░░██║╚██████╔╝╚██████╔╝██████╔╝██████╔╝░░░██║░░░╚█████╔╝╚█████╔╝██║░╚██╗\n" +
                    "╚═╝░░░░░╚═╝╚═╝░░╚═╝░╚═════╝░░╚═════╝░╚═════╝░╚═════╝░░░░╚═╝░░░░╚════╝░░╚════╝░╚═╝░░╚═╝";
    public static final String DASHBOARDLOGO =
            "██████╗░░█████╗░░██████╗██╗░░██╗██████╗░░█████╗░░█████╗░██████╗░██████╗░\n" +
                    "██╔══██╗██╔══██╗██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗██╔══██╗██╔══██╗\n" +
                    "██║░░██║███████║╚█████╗░███████║██████╦╝██║░░██║███████║██████╔╝██║░░██║\n" +
                    "██║░░██║██╔══██║░╚═══██╗██╔══██║██╔══██╗██║░░██║██╔══██║██╔══██╗██║░░██║\n" +
                    "██████╔╝██║░░██║██████╔╝██║░░██║██████╦╝╚█████╔╝██║░░██║██║░░██║██████╔╝\n" +
                    "╚═════╝░╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░";

    public static final String INVENTORYLOGO =
            "██╗███╗░░██╗██╗░░░██╗███████╗███╗░░██╗████████╗░█████╗░██████╗░██╗░░░██╗\n" +
                    "██║████╗░██║██║░░░██║██╔════╝████╗░██║╚══██╔══╝██╔══██╗██╔══██╗╚██╗░██╔╝\n" +
                    "██║██╔██╗██║╚██╗░██╔╝█████╗░░██╔██╗██║░░░██║░░░██║░░██║██████╔╝░╚████╔╝░\n" +
                    "██║██║╚████║░╚████╔╝░██╔══╝░░██║╚████║░░░██║░░░██║░░██║██╔══██╗░░╚██╔╝░░\n" +
                    "██║██║░╚███║░░╚██╔╝░░███████╗██║░╚███║░░░██║░░░╚█████╔╝██║░░██║░░░██║░░░\n" +
                    "╚═╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░";

    public static final String GREET_MESSAGE = "Welcome to MagusStock. How may I assist you today?";
    public static final String EXIT_MESSAGE = "Hope you had an enjoyable experience. See you next time!";
    public static final String UNKNOWN_COMMAND = "I don't understand that command, please refer to the user guide " +
            "or enter 'help' for all available commands";
    public static final String INVALID_ADD = "Wrong/Incomplete Format! Please add new items in the following format: " +
            "add n/[name] upc/[UPC] qty/[quantity] p/[price]\nTip: Ensure that your UPC, quantity and price are all " +
            "in numbers and within valid range";

    public static final String INVALID_AUTO_SAVE_INPUT = "Invalid input! Please enter either 'on' or 'off' to " +
            "enable/disable auto-save";
    public static final String AUTOSAVE_ON = "Auto-save has been enabled!";
    public static final String AUTOSAVE_OFF = "Auto-save has been disabled!";
    public static final String DUPLICATE_ADD = "Duplicate item found! Please add another item with a different UPC";
    public static final String SUCCESS_ADD = "Successfully added the item(s) into the system!";

    public static final String SUCCESS_LIST = "Here are the items in your inventory:";

    public static final String EMPTY_LIST = "There are no items in your inventory.";
    public static final String CONFIRM_MESSAGE = "Are you sure you want this item to be permanently deleted?\n(Y/N)";

    public static final String INVALID_SESSION_FILE = "INFO: A Session Inventory file was found but it is corrupted. " +
            "\n" + "      Please delete the corrupt .csv file.";
    public static final String RECOVERED_SESSION_FILE = "INFO: Session Inventory Data recovered." +
            " The inventory has been updated.";
    public static final String EMPTY_SESSION_FILE = "INFO: Empty/No Session Inventory file found.";

    public static final String INVALID_ALERT_FILE = "INFO: A Session Alerts file was found but it is corrupted. " +
            "\n" + "      Please delete the corrupt .csv file.";

    public static final String EMPTY_ALERT_FILE = "INFO: Empty/No Session Alerts file found.";

    public static final String RECOVERED_ALERT_FILE = "INFO: Session Alert Data recovered." +
            " The list of active alerts has been updated.";

    public static final int INVENTORY_ATTRIBUTE_COUNT = 4;
    public static final int HELP_ATTRIBUTE_COUNT = 2;
    public static final int ALERT_ATTRIBUTE_COUNT = 3;

    public static final int NAME_COL_WIDTH = 15;
    public static final int UPC_COL_WIDTH = 12;
    public static final int QTY_COL_WIDTH = 8;

    public static final int PRICE_COL_WIDTH = 8;
    public static final int COMMAND_COL_WIDTH = 25;
    public static final int FORMAT_COL_WIDTH = 25;
    public static final String INVALID_EDIT_FORMAT = "Wrong/Incomplete Format! Please edit items in the following " +
            "format: " + "edit upc/[UPC] {n/[Name] qty/[Quantity] p/[Price] c/[Category]}";
    public static final String ITEM_NOT_FOUND = "Command failed! Reason: Item not found in database. Please add item " +
            "first!";
    public static final String SUCCESS_EDIT = "Successfully edited the following item:";
    public static final String SUCCESS_RESTOCK = "Successfully restocked the following item:";
    public static final String SUCCESS_SELL = "Successfully sold the following item:";
    public static final String ITEM_NOT_EDITED = "Item Specified will not be updated.";
    public static final String WRONG_QUANTITY_INPUT = "For Quantity inputs: MUST BE a WHOLE NUMBER.";
    public static final String WRONG_PRICE_INPUT = "For Price inputs: MUST BE a WHOLE NUMBER/DECIMAL NUMBER.";
    public static final String INVALID_RESTOCK_FORMAT = "Wrong/Incomplete Format! Please restock items in the " +
            "following format: " + "restock upc/[UPC] qty/[Quantity]";
    public static final String INVALID_ADD_QUANTITY_FORMAT = "Unable to restock item. REASON: Quantity inputs" +
            " SHOULD NOT contain NEGATIVE integers, ZERO(0), or STRING inputs!";
    public static final String INVALID_DEDUCT_QUANTITY_FORMAT = "Unable to sell item. REASON: Quantity inputs" +
            " SHOULD NOT contain NEGATIVE integers, ZERO(0), or STRING inputs!" + "\n" +
            ANSI_RED + "Also ensure that the desired" + " quantity to be deducted is LESS THAN current stock levels."
            + ANSI_RESET;
    public static final String INVALID_SELL_FORMAT = "Wrong/Incomplete Format! Please restock items in the " +
            "following format: " + "sell upc/[UPC] qty/[Quantity]";
    public static final String NO_SEARCH_RESULTS = "Unfortunately, no search results could be found. Try again?";
    public static final String MISSING_PRICE = "Please enter a number for the price!";
    public static final String ITEM_ADDED_AT = "Item added at: ";
    public static final String AT = "At: ";
    public static final String CATEGORY_CHANGED_TO = "Category changed to: ";
    public static final String SOLD = "Sold ";
    public static final String ITEMS = " items";
    public static final String BOUGHT = "Bought ";
    public static final String RENAMED_TO = "Renamed to: ";
    public static final String PRICE_DECREASED_FROM = "Price decreased from $";
    public static final String PRICE_INCREASED_FROM = "Price increased from $";
    public static final String TO_DOLLAR_SIGN = " to $";
    public static final String TAGS_CHANGED_TO = "Tags changed to: ";

    private static final String NAME_HEADING = "Name";
    private static final String UPC_HEADING = "UPC";
    private static final String QTY_HEADING = "Quantity";
    private static final String PRICE_HEADING = "Price";
    private static final String COMMAND_HEADING = "Command";
    private static final String FORMAT_HEADING = "Command Format";

    private static final String TABLE_CORNER = "+";
    private static final String TABLE_ROW = "-";
    private static final String TABLE_LEFT = "| ";
    private static final String TABLE_RIGHT = " |";
    private static final String TABLE_MIDDLE = " | ";

    private static final String DOLLAR_SIGN = "$";
    private static final String SUCCESS_REMOVE = "Successfully removed the following item: ";
    private static final String NOT_REMOVING = "Ok...You changed your mind really quickly.";
    private static final String INVALID_REPLY = "Invalid response, only yes (Y) or no (N) answer is allowed.\n" +
            "Please try again :(";
    private static final String INVALID_INDEX = "This index is invalid.\nPlease enter a number ";

    private static final String INVALID_ALERT_KEYWORD = "Keyword after alert can only be \"add\", \"remove\" " +
            "\"or list\".";
    private static final String INVALID_ADD_ALERT =
            "Wrong/Incomplete Format! Please add new alerts in the following format: \n" +
                    "\"alert add upc/[UPC] min/[integer]\" to set an alert when stock falls below a minimum \n" +
                    " OR\n" +
                    "\"alert add upc/[UPC] max/[integer]\" to set an alert when stock exceeds a maximum. \n";

    private static final String EXISTING_MIN_ALERT = "This item already has a minimum alert. " +
            "Delete the existing one first.";

    private static final String EXISTING_MAX_ALERT = "This item already has a maximum alert. " +
            "Delete the existing one first.";

    private static final String INVALID_MIN_ALERT = "Minimum value to set an alert must be less than existing " + "" +
            "maximum alert value of this item.";

    private static final String INVALID_MAX_ALERT = "Maximum value to set an alert must be more than existing " + "" +
            "mimimum alert value of this item.";

    private static final String SUCCESS_ADD_ALERT = "Successfully added a new alert.";

    private static final String INVALID_REMOVE_ALERT =
            "Wrong/Incomplete Format! " + "Please remove new alerts in the " + "following format: \n" +
                    "\"alert remove upc/[UPC] level/min\" to remove an alert for minimum stock level \n" +
                    " OR\n" +
                    "\"alert remove upc/[UPC] level/max\" to remove an alert for maximum stock level. \n";
    private static final String SUCCESS_REMOVE_ALERT = "Successfully removed the alert.";

    private static final String NONEXISTENT_REMOVE_ALERT = "The alert that you are attempting to remove " +
            "does not exist.";
    private static final String INVALID_CATEGORY_FORMAT = "Wrong/Incomplete Format! Please enter category commands " +
            "as shown below.\n" + "List all categories: cat list\n" + "List all items in a category: cat [Category]\n" +
            "List all items and all categories: cat table";
    private static final int CATEGORY_COL_WIDTH = 15;
    private static final int ITEMS_COL_WIDTH = 30;
    private static final String CATEGORY_HEADING = "Category";
    private static final String NO_CATEGORY_LIST = "Category list is empty. There are no items in the inventory.";
    private static final String INVALID_CATEGORY_FIND = "The category you are looking for does not exist.";
    private static final String INVALID_CATEGORY = "The category does not exist.";
    private static final String NEW_CATEGORY_ADDED = "A new category has been added.";


    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printDoubleNeeded() {
        System.out.println(ANSI_RED + MISSING_PRICE + ANSI_RESET);
    }

    public static void printEmptySearch() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + NO_SEARCH_RESULTS + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSearchUPCItem(Item item) {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + "Here is your item: ");
        ArrayList<Item> singleItem = new ArrayList<>();
        singleItem.add(item);
        System.out.println(printTable(singleItem) + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSearchItems(ArrayList<Item> items) {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + printTable(items) + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printExitMessage() {
        System.out.println(LINE);
        System.out.println(EXIT_MESSAGE);
        System.out.println(LINE);
    }

    public static void greetUser() {
        System.out.println(LINE);
        System.out.println(
                ANSI_ORANGE + LOGO + ANSI_RESET);
        System.out.println(GREET_MESSAGE);
        System.out.println(LINE);
    }

    public static void printInvalidSessionFile() {
        System.out.println(ANSI_YELLOW + INVALID_SESSION_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printRecoveredSessionFile() {
        System.out.println(ANSI_GREEN + RECOVERED_SESSION_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printEmptySessionFile() {
        System.out.println(ANSI_YELLOW + EMPTY_SESSION_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidAlertFile() {
        System.out.println(ANSI_YELLOW + INVALID_ALERT_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printEmptyAlertFile() {
        System.out.println(ANSI_YELLOW + EMPTY_ALERT_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printRecoveredAlertFile() {
        System.out.println(ANSI_GREEN + RECOVERED_ALERT_FILE + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printUnknownCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + UNKNOWN_COMMAND + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidAddCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_ADD + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidAutoSaveInput() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_AUTO_SAVE_INPUT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printAutoSaveEnabled() {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + AUTOSAVE_ON + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printAutoSaveDisabled() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + AUTOSAVE_OFF + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printDuplicateAdd() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + DUPLICATE_ADD + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSuccessAdd() {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + SUCCESS_ADD + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSuccessList() {
        System.out.println(LINE);
        System.out.println(ANSI_CYAN + INVENTORYLOGO + ANSI_CYAN);
        System.out.println(ANSI_GREEN + SUCCESS_LIST + ANSI_RESET);
    }

    public static void printEmptyList() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + EMPTY_LIST + ANSI_RESET);
        System.out.println(LINE);
    }

    public static String printTable(HashMap<String, ArrayList<Item>> categoryHash) {
        int[] columnWidths = {CATEGORY_COL_WIDTH, ITEMS_COL_WIDTH};

        StringBuilder table = new StringBuilder();

        table.append(printTableSeparator(columnWidths));
        table.append(printHeadings(columnWidths));
        table.append(printTableSeparator(columnWidths));
        categoryHash.forEach((category, items)
                -> table.append((printRow(category, items, columnWidths))));
        return table.toString();
    }

    public static String printTable() {
        HashMap<String, String> commandsHashMap = new HashMap<>();
        CommandFormat commandFormat = new CommandFormat(commandsHashMap);
        int[] columnWidths = {COMMAND_COL_WIDTH, FORMAT_COL_WIDTH};

        StringBuilder table = new StringBuilder();

        table.append(printTableSeparator(columnWidths));
        table.append(printHeadings(columnWidths));
        table.append(printTableSeparator(columnWidths));
        commandsHashMap.forEach((format, description)
                -> table.append((printRow(description, format, columnWidths))));
        return table.toString();
    }

    public static String printTable(ArrayList<Item> items) {
        int[] columnWidths = {NAME_COL_WIDTH, UPC_COL_WIDTH, QTY_COL_WIDTH, PRICE_COL_WIDTH};

        StringBuilder table = new StringBuilder();

        table.append(printTableSeparator(columnWidths));
        table.append(printHeadings(columnWidths));
        table.append(printTableSeparator(columnWidths));

        for (Item item : items) {
            String name = item.getName();
            String upc = item.getUpc();
            String qty = Integer.toString(item.getQuantity());
            String price = Double.toString(item.getPrice());

            table.append(printRow(name, upc, qty, price, columnWidths));
        }
        return table.toString();
    }

    public static String printTable(HashMap<String, Integer> upcMap, Inventory inventory) {

        int[] columnWidths = {NAME_COL_WIDTH, UPC_COL_WIDTH, QTY_COL_WIDTH};
        StringBuilder table = new StringBuilder();
        table.append(printTableSeparator(columnWidths));
        table.append(printHeadings(columnWidths));
        table.append(printTableSeparator(columnWidths));

        HashMap<String, Item> inventoryMap = inventory.getUpcCodes();

        upcMap.forEach((key, value)
                -> table.append(printRow(inventoryMap.get(key).getName(), key, value.toString(), columnWidths)));

        return table.toString();

    }

    private static String printHeadings(int[] columnWidths) {
        String[] headings = {};
        if (columnWidths.length == INVENTORY_ATTRIBUTE_COUNT) {
            headings = new String[]{NAME_HEADING, UPC_HEADING, QTY_HEADING, PRICE_HEADING};
        } else if (columnWidths.length == HELP_ATTRIBUTE_COUNT && columnWidths[0] == COMMAND_COL_WIDTH) {
            headings = new String[]{COMMAND_HEADING, FORMAT_HEADING};
        } else if (columnWidths.length == ALERT_ATTRIBUTE_COUNT) {
            headings = new String[]{"Name", "UPC", "Stock"};
        } else if (columnWidths.length == HELP_ATTRIBUTE_COUNT && columnWidths[0] == CATEGORY_COL_WIDTH) {
            headings = new String[]{CATEGORY_HEADING, NAME_HEADING + ": " + UPC_HEADING};
        }
        StringBuilder allHeadings = new StringBuilder();

        for (int i = 0; i < headings.length; i += 1) {
            String heading = headings[i];
            int width = columnWidths[i];
            String formattedHeading = String.format(TABLE_LEFT + "%-" + width + "s ", heading);
            allHeadings.append(formattedHeading);
        }

        allHeadings.append(TABLE_LEFT.replaceAll(" ", ""));
        allHeadings.append(System.lineSeparator());

        return allHeadings.toString();
    }

    private static String printTableSeparator(int[] columnWidths) {
        StringBuilder tableSeparator = new StringBuilder();

        for (int columnWidth : columnWidths) {
            tableSeparator.append(TABLE_CORNER);
            tableSeparator.append(TABLE_ROW.repeat(columnWidth + 2));
        }

        tableSeparator.append(TABLE_CORNER);
        tableSeparator.append(System.lineSeparator());
        return tableSeparator.toString();
    }

    private static String printRow(String description, String format, int[] columnWidths) {
        String[] descriptionLines = wrapText(description, COMMAND_COL_WIDTH);
        String[] formatLines = wrapText(format, FORMAT_COL_WIDTH);
        StringBuilder row = new StringBuilder();

        int rowHeight = findRowHeight(descriptionLines, formatLines);

        for (int i = 0; i < rowHeight; i += 1) {
            row.append(TABLE_LEFT);
            row.append(printAttribute(descriptionLines, COMMAND_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(formatLines, FORMAT_COL_WIDTH, i));
            row.append(TABLE_RIGHT);
            row.append(System.lineSeparator());

            if (i == rowHeight - 1) {
                row.append(printTableSeparator(columnWidths));
            }
        }
        return row.toString();
    }

    private static String printRow(String category, ArrayList<Item> items, int[] columnWidths) {
        String[] categoryLines = wrapText(category, CATEGORY_COL_WIDTH);
        ArrayList<String> itemLines = new ArrayList<>();
        StringBuilder row = new StringBuilder();

        for (Item item : items) {
            String name = item.getName();
            String upc = item.getUpc();
            itemLines.add(name + ":" + upc);
        }
        String[] itemListLines = wrapText(itemLines.toString(), ITEMS_COL_WIDTH);
        int rowHeight = findRowHeight(categoryLines, itemListLines);

        for (int i = 0; i < rowHeight; i += 1) {
            row.append(TABLE_LEFT);
            row.append(printAttribute(categoryLines, CATEGORY_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(itemListLines, ITEMS_COL_WIDTH, i));
            row.append(TABLE_RIGHT);
            row.append(System.lineSeparator());

            if (i == rowHeight - 1) {
                row.append(printTableSeparator(columnWidths));
            }
        }
        return row.toString();
    }

    private static String printRow(String name, String upc, String qty, String price,
                                   int[] columnWidths) {
        String[] nameLines = wrapText(name, NAME_COL_WIDTH);
        String[] upcLines = wrapText(upc, UPC_COL_WIDTH);
        String[] qtyLines = wrapText(qty, QTY_COL_WIDTH);
        String[] priceLines = wrapText(DOLLAR_SIGN + price, PRICE_COL_WIDTH);
        StringBuilder row = new StringBuilder();

        int rowHeight = findRowHeight(nameLines, upcLines, qtyLines, priceLines);

        for (int i = 0; i < rowHeight; i += 1) {
            row.append(TABLE_LEFT);
            row.append(printAttribute(nameLines, NAME_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(upcLines, UPC_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(qtyLines, QTY_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(priceLines, PRICE_COL_WIDTH, i));
            row.append(TABLE_RIGHT);
            row.append(System.lineSeparator());

            if (i == rowHeight - 1) {
                row.append(printTableSeparator(columnWidths));
            }
        }
        return row.toString();
    }

    private static String printRow(String name, String upc, String stock, int[] columnWidths) {
        String[] upcLines = wrapText(upc, UPC_COL_WIDTH);
        String[] stockLines = wrapText(stock, QTY_COL_WIDTH);
        String[] nameLines = wrapText(name, NAME_COL_WIDTH);
        StringBuilder row = new StringBuilder();

        int rowHeight = findRowHeight(upcLines, stockLines, nameLines);

        for (int i = 0; i < rowHeight; i += 1) {
            row.append(TABLE_LEFT);
            row.append(printAttribute(nameLines, NAME_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(upcLines, UPC_COL_WIDTH, i));
            row.append(TABLE_MIDDLE);
            row.append(printAttribute(stockLines, QTY_COL_WIDTH, i));
            row.append(TABLE_RIGHT);
            row.append(System.lineSeparator());

            if (i == rowHeight - 1) {
                row.append(printTableSeparator(columnWidths));
            }
        }

        return row.toString();
    }

    private static String printAttribute(String[] attributeLines, int columnWidth, int rowNumber) {
        StringBuilder attribute = new StringBuilder();

        if (rowNumber < attributeLines.length) {
            String paddedAttribute = String.format("%1$-" + columnWidth + "s", attributeLines[rowNumber]);
            attribute.append(paddedAttribute);
        } else {
            String paddedSpace = new String(new char[columnWidth]).replace('\0', ' ');
            attribute.append(paddedSpace);
        }
        return attribute.toString();
    }

    /* Method below adapted from https://stackoverflow.com/questions/4055430/java-
    code-for-wrapping-text-lines-to-a-max-line-width */
    private static String[] wrapText(String input, int width) {
        if (input.contains("[")) {
            input = input.replace("[", "");
        }
        if (input.contains("]")) {
            input = input.replace("]", "");
        }
        String[] words = input.split("\\s+");
        ArrayList<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < words.length; i += 1) {
            if (line.length() + words[i].length() <= width) {
                line = addWordWithoutWrap(line, words, lines, i, width);
            } else if (words[i].length() > width) {
                addWordWithWrap(words, lines, i, width);
            } else {
                lines.add(line.toString());
                line = new StringBuilder(words[i] + " ");
            }
        }

        if (line.length() > 0) {
            lines.add(line.toString());
        }
        return lines.toArray(new String[0]);
    }

    private static StringBuilder addWordWithoutWrap(StringBuilder line, String[] words, ArrayList<String> lines,
                                                    int current, int width) {
        line.append(words[current]);

        if (line.length() < width) {
            line.append(" ");
        }

        if (words[current].equals(",")) {
            for (int i = 0; i < width - line.length(); i++) {
                line.append(" ");
            }
        }

        if (current + 1 != words.length && line.length() + words[current + 1].length() > width) {
            lines.add(line.toString());
            line = new StringBuilder();
        }
        return line;
    }

    private static void addWordWithWrap(String[] words, ArrayList<String> lines, int current, int width) {
        int start = 0;
        while (start < words[current].length()) {
            int end = Math.min(start + width, words[current].length());
            lines.add(words[current].substring(start, end));
            start = end;
        }
    }

    private static int findRowHeight(String[]... rowHeights) {
        int maxAttributeHeight = 0;

        for (String[] rowHeight : rowHeights) {
            if (rowHeight.length > maxAttributeHeight) {
                maxAttributeHeight = rowHeight.length;
            }
        }
        return maxAttributeHeight;
    }

    /**
     * Informs the user that his/her edit command is of the wrong format, by the printing a string to show the correct
     * format instead.
     */
    public static void printInvalidEditCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_EDIT_FORMAT + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints a string to inform the user that the item with the specified UPC code cannot be found inside the database.
     */
    public static void printItemNotFound() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + ITEM_NOT_FOUND + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Calls a method to prints the updated version of the item in question, or else calls a method to print a string
     * to inform the user that the item in question is not updated due to an error in his or her inputs.
     *
     * @param oldItem     The item containing the old attributes.
     * @param updatedItem The same item but with new attributes as defined by the user.
     * @throws EditErrorException The exception used to handle all errors related to the "Edit" command.
     */
    public static void printEditDetails(Item oldItem, Item updatedItem) throws EditErrorException {
        try {
            if (!updatedItem.isUpdatedFrom(oldItem)) {
                throw new EditErrorException();
            }
            printUpdatedItemDetails(oldItem, updatedItem);
            assert Objects.equals(oldItem.getUpc(), updatedItem.getUpc()) : "Both items should be of same UPC Code.";
        } catch (EditErrorException eee) {
            printItemNotUpdatedError();
        }
    }


    /**
     * Prints the updated attributes of the item as specified by the user. Shows both the previous attributes
     * and the updated attributes of the item.
     *
     * @param oldItem     The item containing the old attributes.
     * @param updatedItem The same item but with new attributes as defined by the user.
     */
    private static void printUpdatedItemDetails(Item oldItem, Item updatedItem) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + SUCCESS_EDIT + ANSI_RESET + "\n");
        System.out.println(ANSI_RED + "Before Update: " + ANSI_RESET);
        System.out.println(oldItem.toString());
        System.out.println("\n" + ANSI_GREEN + "After Update: " + ANSI_RESET);
        System.out.println(updatedItem.toString());
        System.out.println(LINE);
    }

    /**
     * Prints the updated quantity of an item specified by the user. Shows both the previous quantity
     * and the updated quantity of the item after restocking.
     *
     * @param oldItem     The item containing the old attributes.
     * @param updatedItem The same item but with new attributes as defined by the user.
     */
    public static void printRestockDetails(Item oldItem, Item updatedItem) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + SUCCESS_RESTOCK + ANSI_RESET + "\n");
        System.out.println(ANSI_RED + "Before Restocking: " + ANSI_RESET);
        System.out.println("Item Name: " + oldItem.getName() + "\n" + "UPC Code: " + oldItem.getUpc() + "\n" +
                "Quantity Available: " + ANSI_RED + oldItem.getQuantity() + ANSI_RESET);
        System.out.println("\n" + ANSI_GREEN + "After Restocking: " + ANSI_RESET);
        System.out.println("Item Name: " + updatedItem.getName() + "\n" + "UPC Code: " + updatedItem.getUpc() + "\n" +
                "Quantity Available: " + ANSI_GREEN + updatedItem.getQuantity() + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints the updated quantity of an item specified by the user. Shows both the previous quantity
     * and the updated quantity of the item after selling, as well as the price its sold at.
     *
     * @param oldItem     The item containing the old attributes.
     * @param updatedItem The same item but with new attributes as defined by the user.
     */
    public static void printSellDetails(Item oldItem, Item updatedItem) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + SUCCESS_SELL + ANSI_RESET + "\n");
        System.out.println(ANSI_RED + "Before Selling: " + ANSI_RESET);
        System.out.println("Item Name: " + oldItem.getName() + "\n" + "UPC Code: " + oldItem.getUpc() + "\n" +
                "Quantity Available: " + ANSI_RED + oldItem.getQuantity() + ANSI_RESET);
        System.out.println("\n" + ANSI_GREEN + "After Selling: " + ANSI_RESET);
        System.out.println("Item Name: " + updatedItem.getName() + "\n" + "UPC Code: " + updatedItem.getUpc() + "\n" +
                "Quantity Available: " + ANSI_GREEN + updatedItem.getQuantity() + ANSI_RESET);
        System.out.println("\n" + ANSI_BLUE + "Sold " + ANSI_CYAN + (oldItem.getQuantity() - updatedItem.getQuantity())
                + " " + ANSI_BLUE + updatedItem.getName() + " at a price of $" + ANSI_CYAN + updatedItem.getPrice() +
                "." + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints an error message to inform the user that the item is not updated.
     */
    private static void printItemNotUpdatedError() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + ITEM_NOT_EDITED + ANSI_RESET);
        System.out.println(ANSI_RED + "REASON: Item's name/price/quantity is the same as user's input." + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints an error message to inform the user that item is not updated due to wrong quantity/price input type.
     */
    public static void printInvalidPriceOrQuantityEditInput() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + ITEM_NOT_EDITED + ANSI_RESET);
        System.out.println(ANSI_RED + "REASON:" + ANSI_RESET);
        System.out.println(ANSI_RED + WRONG_QUANTITY_INPUT + ANSI_RESET);
        System.out.println(ANSI_RED + WRONG_PRICE_INPUT + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints an error message to inform the user that the user command for restock is invalid.
     */
    public static void printInvalidRestockCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_RESTOCK_FORMAT + ANSI_RESET);
        System.out.println(LINE);

    }

    /**
     * Prints an error message to inform the user that the "restock" command contains negative values or strings.
     */
    public static void printInvalidAddQuantityInput() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_ADD_QUANTITY_FORMAT + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints an error message to inform the user that the "sell" command contains negative values or strings.
     */
    public static void printInvalidDeductQuantityInput() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_DEDUCT_QUANTITY_FORMAT + ANSI_RESET);
        System.out.println(LINE);
    }

    /**
     * Prints an error message to inform the user that the user command for selling is invalid.
     */
    public static void printInvalidSellCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_SELL_FORMAT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidReply() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_REPLY + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printNotRemoving() {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + NOT_REMOVING + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSuccessRemove(Item itemToRemove) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + SUCCESS_REMOVE + ANSI_RESET);
        System.out.println(itemToRemove.toString());
        System.out.println(LINE);
    }

    public static void printConfirmMessage(Item itemToRemove) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + CONFIRM_MESSAGE + ANSI_RESET);
        System.out.println(itemToRemove.toString());
        System.out.println(LINE);
    }

    public static void printInvalidIndex(Inventory inventory) {
        System.out.println(LINE);
        int listSize = inventory.getItemInventory().size();
        switch (listSize) {
        case 0:
            System.out.println(ANSI_RED + EMPTY_LIST + ANSI_RESET);
            break;
        case 1:
            System.out.println(ANSI_RED + INVALID_INDEX + "0 to remove item successfully." + ANSI_RESET);
            break;
        default:
            System.out.println(ANSI_RED + INVALID_INDEX + "between 0 to " + (listSize - 1) +
                    " to remove item successfully." + ANSI_RESET);
            break;
        }
        System.out.println(LINE);
    }

    public static void printInvalidUpc(Inventory inventory) {
        System.out.println(LINE);
        int listSize = inventory.getItemInventory().size();
        if (listSize == 0) {
            System.out.println(ANSI_RED + EMPTY_LIST + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "This UPC is invalid. Try again." + ANSI_RESET);
        }
        System.out.println(LINE);
    }

    public static void printExistingMinAlert() {
        System.out.println(ANSI_RED + EXISTING_MIN_ALERT + ANSI_RESET);
    }

    public static void printExistingMaxAlert() {
        System.out.println(ANSI_RED + EXISTING_MAX_ALERT + ANSI_RESET);
    }

    public static void printInvalidAddAlertCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_ADD_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidMinAlert() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_MIN_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidMaxAlert() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_MAX_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSuccessAddAlert() {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + SUCCESS_ADD_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidAlertKeyword() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_ALERT_KEYWORD + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidRemoveAlertCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_REMOVE_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printSuccessRemoveAlertCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + SUCCESS_REMOVE_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printNonExistentRemoveAlert() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + NONEXISTENT_REMOVE_ALERT + ANSI_RESET);
        System.out.println(LINE);
    }

    private static String printAlerts(Inventory inventory, AlertList alertList) {

        StringBuilder alertTable = new StringBuilder();

        boolean hasMinAlerts = !alertList.getMinAlertUpcs().isEmpty();
        boolean hasMaxAlerts = !alertList.getMaxAlertUpcs().isEmpty();

        String minAlertTable = "";
        String maxAlertTable = "";

        if (hasMinAlerts) {
            minAlertTable = Ui.printTable(alertList.getMinAlertUpcs(), inventory);
            alertTable.append(ANSI_CYAN + "Alerts for minimum stock level:" + ANSI_RESET + System.lineSeparator());
            alertTable.append(minAlertTable);
        }

        if (hasMaxAlerts) {
            if (hasMinAlerts) {
                alertTable.append(System.lineSeparator());
            }
            maxAlertTable = Ui.printTable(alertList.getMaxAlertUpcs(), inventory);
            alertTable.append(ANSI_CYAN + "Alerts for maximum stock level:" + ANSI_RESET + System.lineSeparator());
            alertTable.append(maxAlertTable);
        }

        if (!hasMinAlerts && !hasMaxAlerts) {
            alertTable.append("No alerts to print.");
        }

        return alertTable.toString();
    }

    public static void printDashboard(Inventory inventory, AlertList alertList) {
        Item mostQuantityItem = inventory.getUpcCodes().get(inventory.getItemWithMostQuantity());
        Item leastQuantityItem = inventory.getUpcCodes().get(inventory.getItemWithLeastQuantity());
        System.out.println(LINE);
        System.out.println(ANSI_YELLOW + DASHBOARDLOGO + ANSI_RESET);
        System.out.println("Overview:");
        System.out.println(LINE);
        System.out.println(ANSI_ORANGE + "Total number of items: " + ANSI_WHITE +
                inventory.getItemInventory().size() + ANSI_RESET);
        System.out.println(ANSI_ORANGE + "Total number of active alerts: " + ANSI_WHITE +
                alertList.getTotalAlertNumber() + ANSI_RESET);

        System.out.println(ANSI_ORANGE + "Total value of inventory: " + ANSI_WHITE +
                "$" + inventory.getTotalValue() + ANSI_RESET);
        if (!inventory.getItemInventory().isEmpty()) {
            System.out.println(ANSI_ORANGE + "Item with most quantity: " + ANSI_GREEN + mostQuantityItem.getName() +
                    " (" + mostQuantityItem.getQuantity() + ") " + ANSI_RESET);
            System.out.println(ANSI_ORANGE + "Item with least quantity: " + ANSI_RED + leastQuantityItem.getName() +
                    " (" + leastQuantityItem.getQuantity() + ") " + ANSI_RESET);
        }
        System.out.println(LINE);
        System.out.println(ANSI_CYAN + "Current Session Configurations:" + ANSI_RESET);
        System.out.println(LINE);
        if (SessionManager.getAutoSave()) {
            System.out.println("AutoSave Mode: " + ANSI_GREEN + "TRUE" + ANSI_RESET);
        } else {
            System.out.println("AutoSave Mode: " + ANSI_RED + "FALSE" + ANSI_RESET);
        }
        System.out.println("Inventory Data File Status: " + SessionManager.inventoryDataFileExist());
        System.out.println("Alerts Data File Status: " + SessionManager.alertDataFileExist());
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + "List of active alerts:" + ANSI_RESET);

        String alertTable = printAlerts(inventory, alertList);

        System.out.println(alertTable);
        System.out.println(LINE);
    }

    public static void printHistory(ArrayList<Item> results) {
        System.out.println(ANSI_ORANGE + LINE + ANSI_RESET);
        System.out.println(ITEM_ADDED_AT + results.get(0).getDateTimeString());
        System.out.println(results.get(0).toString());
        System.out.println(ANSI_ORANGE + LINE + ANSI_RESET);
        for (int i = 1; i < results.size(); i++) {
            System.out.println(ANSI_ORANGE + LINE + ANSI_RESET);
            System.out.println(AT + results.get(i).getDateTimeString() + ANSI_CYAN);
            ArrayList<Types.EditType> edits = results.get(i - 1).getEditTypes(results.get(i));
            for (Types.EditType editType : edits) {
                switch (editType) {
                case RECATEGORIZE:
                    System.out.println(CATEGORY_CHANGED_TO + results.get(i).getCategory());
                    break;
                case SOLD:
                    System.out.print(SOLD + (results.get(i - 1).getQuantity() - results.get(i).getQuantity()));
                    System.out.println(ITEMS);
                    break;
                case BOUGHT:
                    System.out.print(BOUGHT + (results.get(i).getQuantity() - results.get(i - 1).getQuantity()));
                    System.out.println(ITEMS);
                    break;
                case RENAME:
                    System.out.println(RENAMED_TO + results.get(i).getName());
                    break;
                case PRICE_DECREASE:
                    System.out.print(PRICE_DECREASED_FROM + results.get(i - 1).getPrice());
                    System.out.println(TO_DOLLAR_SIGN + results.get(i).getPrice());
                    break;
                case PRICE_INCREASE:
                    System.out.print(PRICE_INCREASED_FROM + results.get(i - 1).getPrice());
                    System.out.println(TO_DOLLAR_SIGN + results.get(i).getPrice());
                    break;
                case CHANGE_TAG:
                    ArrayList<String> tags = results.get(i - 1).getTags();
                    if (!tags.isEmpty()) {
                        System.out.print(TAGS_CHANGED_TO);
                        for (int j = 0; j < tags.size() - 1; j++) {
                            System.out.print(tags.get(j) + ", ");
                        }
                        System.out.println(tags.get(tags.size() - 1));
                    }
                    break;
                default:
                    break;
                }
            }
            System.out.println(ANSI_ORANGE + LINE + ANSI_RESET);
        }
        if (results.size() > 1) {
            System.out.println(ANSI_ORANGE + LINE);
            System.out.println(ANSI_RESET + results.get(results.size() - 1).toString());
            System.out.println(ANSI_ORANGE + LINE + ANSI_RESET);
        }
    }

    public static void printMinAlertWarning(String name, int alertLevel) {
        System.out.println(ANSI_YELLOW + "ALERT: The quantity of " + ANSI_RED + name + ANSI_RESET + ANSI_YELLOW +
                " is below the minimum level of " + ANSI_RED + alertLevel + ANSI_YELLOW + "." + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printMaxAlertWarning(String name, int alertLevel) {
        System.out.println(ANSI_YELLOW + "ALERT: The quantity of " + ANSI_RED + name + ANSI_RESET + ANSI_YELLOW +
                " is above the maximum level of " + ANSI_RED + alertLevel + ANSI_YELLOW + "." + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidCategoryCommand() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_CATEGORY_FORMAT + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printCategory(HashMap<String, ArrayList<Item>> categoryHash) {
        System.out.println(LINE);
        System.out.println(ANSI_GREEN + printTable(categoryHash) + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printNoCategoryList() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + NO_CATEGORY_LIST + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printInvalidCategory() {
        System.out.println(LINE);
        System.out.println(ANSI_RED + INVALID_CATEGORY_FIND + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printNewCategory() {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + INVALID_CATEGORY + NEW_CATEGORY_ADDED + ANSI_RESET);
        System.out.println(LINE);
    }

    public static void printCategoryList(HashMap<String, ArrayList<Item>> categoryHash) {
        System.out.println(LINE);
        System.out.println(ANSI_BLUE + "Here is the list of categories you have: " + ANSI_RESET);
        categoryHash.forEach((cat, items) -> System.out.println(cat));
        System.out.println(LINE);
    }
}

