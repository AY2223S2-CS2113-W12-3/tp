package seedu.duke.commands;

import seedu.duke.objects.Inventory;
import seedu.duke.objects.Item;
import seedu.duke.utils.Ui;

import java.util.ArrayList;

/**
 * Represents the command to filter items in the inventory.
 */
public class FilterCommand extends Command {
    private static final String LESS_THAN_FLAG = "p/lt";
    private static final String GREATER_THAN_FLAG = "p/gt";
    private static final String LESS_OR_EQUAL_THAN_FLAG = "p/let";
    private static final String GREATER_OR_EQUAL_THAN_FLAG = "p/get";
    private static ArrayList<Item> filteredCategory;
    private String filterType;
    private String filterValue;
    private Double filterPrice;

    /**
     * Constructor for FilterCommand by Category/Tag.
     *
     * @param inventory  Inventory object.
     * @param value      String value to filter by.
     * @param filterMode String category/tag filter mode.
     */
    public FilterCommand(Inventory inventory, final String value, final String filterMode) {
        super(inventory);
        this.filterType = filterMode;
        this.filterValue = value;
    }

    /**
     * Constructor for FilterCommand by Price.
     *
     * @param inventory       Inventory object.
     * @param price           Double value to filter by.
     * @param filterPriceMode String price filtering mode.
     */
    public FilterCommand(Inventory inventory, final double price, final String filterPriceMode) {
        super(inventory);
        this.filterType = filterPriceMode;
        this.filterPrice = price;
    }

    /**
     * Filter items in the inventory by category/tag.
     *
     * @param categoryType String category to filter items by.
     */
    private void filterCategory(String categoryType) {
        // filter f/category list: prints list
        // filter f/category table: prints table
        // filter f/category c/[Keywords]: find category with keyword(s)
        try {
            if (categoryHash.isEmpty()) {
                throw new NullPointerException();
            }
            if (categoryType.equals("list")) {
                Ui.printCategoryList(categoryHash);
            } else if (categoryType.equals("table")) {
                Ui.printCategory(categoryHash);
            } else if (categoryType.startsWith("c/")) {
                //System.out.println("finding keyword");
                String keyword = categoryType.replaceFirst("c/", "");
                //System.out.println("keyword is " + keyword);
                ArrayList<Item> tempFilteredItems = new ArrayList<>();
                for (Item item : itemInventory) {
                    if (item.getCategory().toLowerCase().equals(keyword)) {
                        //filteredItems.add(item);
                        tempFilteredItems.add(item);
                        //System.out.println("item added: " + item.getName());
                    }
                }
                setFilteredCategory(tempFilteredItems);
            }
        } catch (NullPointerException e) { // no categories == no items in list
            Ui.printNoCategoryList(); //for now means no categories
        }
        //categoryType = categoryType.toLowerCase();
    }

    public void setFilteredCategory(ArrayList<Item> filteredCategory) {
        //System.out.println("setting arraylist category");
        this.filteredCategory = filteredCategory;
        //Ui.printCategory(filteredCategory);
    }

    private static ArrayList<Item> getFilteredCategory() {
        if (filteredCategory.isEmpty()) {
            return null;
        }

        return filteredCategory;
    }

    /**
     * Filter items in the inventory by price.
     *
     * @param price Double value to filter items by.
     * @param mode  String price filtering mode.
     *              p/lt - price less than
     *              p/gt - price greater than
     *              p/let - price less than or equal to
     *              p/get - price greater than or equal to
     */
    private ArrayList<Item> filterPrice(final double price, final String mode) {
        ArrayList<Item> filteredItems = new ArrayList<>();
        for (Item item : itemInventory) {
            switch (mode) {
            case LESS_THAN_FLAG:
                if (item.getPrice() < price) {
                    filteredItems.add(item);
                }
                break;
            case GREATER_THAN_FLAG:
                if (item.getPrice() > price) {
                    filteredItems.add(item);
                }
                break;
            case LESS_OR_EQUAL_THAN_FLAG:
                if (item.getPrice() <= price) {
                    filteredItems.add(item);
                }
                break;
            case GREATER_OR_EQUAL_THAN_FLAG:
                if (item.getPrice() >= price) {
                    filteredItems.add(item);
                }
                break;
            default:
                break;
            }
        }
        if (filteredItems.isEmpty()) {
            return null;
        }
        return filteredItems;
    }

    /**
     * Gets a list on filtered items based on the filter mode.
     *
     * @return ArrayList Item of filtered items. If no items are found, returns null instead.
     */

    public ArrayList<Item> getFilteredItems(){
        ArrayList<Item> filteredItems = new ArrayList<>();
        switch (filterType) {
        case "f/category":
            //System.out.println(filterValue + " is passed to filter category");
            filterCategory(filterValue); //filterValue = "list"/"table"/"c/[keyword(s)]"
            if (filterValue.startsWith("c/")) {
                //System.out.println("trying to get filtered category...");
                filteredItems = getFilteredCategory();
            }
            break;
        case "p/lt":
        case "p/gt":
        case "p/let":
        case "p/get":
            filteredItems = filterPrice(filterPrice, filterType);
            break;
        default:
            break;
        }
        return filteredItems;
    }

    /**
     * Delegate and executes the correct filter command.
     */
    @Override
    public void run() {
        ArrayList<Item> filteredItems = getFilteredItems();
        if(filteredItems == null){
            Ui.printEmptySearch();
        } else if (filterType.startsWith("f/category")) {
            System.out.println("executed accordingly");
        } else {
            Ui.printSearchItems(filteredItems);
        }
    }
}
