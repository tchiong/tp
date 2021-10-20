package seedu.address.logic.parser;

import seedu.address.logic.commands.FindAppCommand;
import seedu.address.logic.commands.ListAppCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

/**
 * Parses input arguments and creates a new FindAppCommand object
 */
public class ListAppCommandParser implements Parser<FindAppCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindAppCommand
     * and returns a FindAppCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     * @return
     */
    public ListAppCommand parse (String args) throws ParseException {
        String sortBy = args.trim();

        return new ListAppCommand(sortBy);
    }

}
