package seedu.duke.utils.parsers;

import seedu.duke.commands.AddCommand;
import seedu.duke.commands.Command;
import seedu.duke.exceptions.MissingParametersException;
import seedu.duke.objects.Inventory;
import seedu.duke.objects.Item;
import seedu.duke.utils.Ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddParser extends Parser {


    public AddParser(final String rawInput, final Inventory inventory) {
        super(rawInput, inventory);
    }

    /**
     * Handles the "add" command by parsing the user's input into separate input parameters using regex
     */
    @Override
    public void run() {
        try {
            if (rawInput == null) {
                throw new MissingParametersException();
            }
            Matcher matcher = Pattern.compile(ADD_REGEX).matcher(rawInput);
            if (!matcher.matches()) {
                Ui.printInvalidAddCommand();
                return;
            }
            Item newItem = new Item(matcher.group(NAME_INDEX), matcher.group(UPC_INDEX),
                    Integer.parseInt(matcher.group(QTY_INDEX)), Double.parseDouble(matcher.group(PRICE_INDEX)),
                    matcher.group(CAT_INDEX));
            Command addCommand = new AddCommand(inventory, newItem);
            addCommand.run();
        } catch (MissingParametersException e) {
            e.missingAddItemParameters();
        } catch (NumberFormatException e) {
            Ui.printInvalidAddCommand();
        }
    }
}
