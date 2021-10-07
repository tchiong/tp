package seedu.address.logic.commands;

import seedu.address.model.Model;
/**
 * List all appointments in PlaceBook to the user.
 */
public class ListAppCommand extends Command {
    public static final String COMMAND_WORD = "listApp";

    public static final String MESSAGE_SUCCESS = "listed all appointments";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("ListAppCommand.");
    }
}
