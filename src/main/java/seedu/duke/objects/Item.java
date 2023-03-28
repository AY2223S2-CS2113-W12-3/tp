package seedu.duke.objects;

import seedu.duke.types.Types;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.time.LocalDateTime;

public class Item implements Comparable<Item> {
    private final LocalDateTime dateTime;
    private String upc;
    private String name;
    private Double price;
    private Integer quantity;
    private String category = "Uncategorized";
    private ArrayList<String> tags = new ArrayList<>();

    public Item(String name, String upc, Integer qty, Double price) {
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.quantity = qty;
        this.dateTime = LocalDateTime.now();
    }

    public Item(final String name, final String upc, final Integer qty,
                final Double price, final String category, final ArrayList<String> tags) {
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.quantity = qty;
        this.category = category;
        for (String tag : tags) {
            this.tags.add(tag);
        }
        this.dateTime = LocalDateTime.now();
    }

    public Item(final String name, final String upc, final Integer qty,
                final Double price, final String category, final LocalDateTime dateTime) {
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.quantity = qty;
        this.category = category;
        this.dateTime = dateTime;
    }

    public Item(final String name, final String upc, final Integer qty,
                final Double price, final String category) {
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.quantity = qty;
        this.category = category;
        this.dateTime = LocalDateTime.now();
    }

    public Item(Item item) {
        this.name = item.getName();
        this.dateTime = item.getDateTime();
        this.upc = item.getUpc();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.category = item.getCategory();
        for (String tag : item.getTags()) {
            tags.add(tag);
        }
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(final ArrayList<String> tags) {
        this.tags = tags;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public String getUpc() {
        return upc;
    }

    public void setUpc(final String upc) {
        this.upc = upc;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Retrieves the quantity of the item.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Updates the quantity of the item.
     */
    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isUpdatedFrom(Item oldItem) {
        int itemsChanged = 0;
        if (!Objects.equals(oldItem.getName(), this.getName())) {
            itemsChanged += 1;
        }
        if (!Objects.equals(oldItem.getQuantity(), this.getQuantity())) {
            itemsChanged += 1;
        }
        if (!Objects.equals(oldItem.getPrice(), this.getPrice())) {
            itemsChanged += 1;
        }
        if (!Objects.equals(oldItem.getCategory(), this.getCategory())) {
            itemsChanged += 1;
        }
        return itemsChanged != 0;
    }

    public ArrayList<Types.EditType> getEditTypes(final Item item) {
        ArrayList<Types.EditType> results = new ArrayList<>();
        if (quantity < item.getQuantity()) {
            results.add(Types.EditType.BOUGHT);
        }
        if (quantity > item.getQuantity()) {
            results.add(Types.EditType.SOLD);
        }
        if (!category.equals(item.getCategory())) {
            results.add(Types.EditType.RECATEGORIZE);
        }
        if (!name.equals(item.getName())) {
            results.add(Types.EditType.RENAME);
        }
        if (price < item.getPrice()) {
            results.add(Types.EditType.PRICE_INCREASE);
        }
        if (price > item.getPrice()) {
            results.add(Types.EditType.PRICE_DECREASE);
        }
        if (!tags.equals(item.getTags())) {
            results.add(Types.EditType.CHANGE_TAG);
        }
        return results;
    }

    private static String getDateString(final LocalDate date) {
        return date.getDayOfWeek() + ", " + date.getMonth() + " " + date.getDayOfMonth() + ", " + date.getYear();
    }

    private static int adjustHour(final int hour) {
        if (hour % 12 == 0) {
            return 12;
        }
        return hour % 12;
    }

    private static String getTimeString(final LocalTime time) {
        LocalTime noon = LocalTime.parse("12:00");
        return adjustHour(time.getHour()) + ":" + (time.getMinute() < 10 ? "0" : "") + time.getMinute()
                + " " + (time.isBefore(noon) ? "AM" : "PM");
    }

    public String getDateTimeString() {
        LocalDate date = dateTime.toLocalDate();
        LocalTime time = dateTime.toLocalTime();
        return getTimeString(time) + ", " + getDateString(date);
    }

    @Override
    public String toString() {
        String returnString = "Name: " + name + '\n' + "UPC: " + upc + '\n' + "Price: " + price + '\n'
                + "Quantity: " + quantity + '\n' + "Category: " + category;
        if (!tags.isEmpty()) {
            returnString += "\nTags: ";
        }
        for (int i = 0; i < tags.size(); i++) {
            returnString += tags.get(i);
            if (i < tags.size() - 1) {
                returnString += ", ";
            }
        }
        return returnString;
    }

    @Override
    public boolean equals(final Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        Item item = (Item) o;
        if (item.getUpc().equals(upc)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(final Item item) {
        if (item.getDateTime() == null || dateTime == null) {
            return 0;
        }
        if (item.getDateTime().isEqual(dateTime)) {
            return 0;
        }
        if (dateTime.isBefore(item.getDateTime())) {
            return -1;
        }
        return 1;
    }
}
