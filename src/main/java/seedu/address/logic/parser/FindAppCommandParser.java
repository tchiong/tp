package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindAppCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.schedule.DescriptionContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindAppCommand object
 */
public class FindAppCommandParser implements Parser<FindAppCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindAppCommand
     * and returns a FindAppCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     * @return FindAppCommand
     */
    public FindAppCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAppCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindAppCommand(new DescriptionContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
