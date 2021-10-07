package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddAppCommand;
import seedu.address.logic.commands.DelAppCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Address;

public class DelAppCommandParser implements Parser<DelAppCommand> {

    @Override
    public DelAppCommand parse(String args) throws ParseException {

        Index index;

        try {
            index = ParserUtil.parseIndex(args);
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DelAppCommand.MESSAGE_USAGE), pe);
        }

        return new DelAppCommand(index);
    }

}
