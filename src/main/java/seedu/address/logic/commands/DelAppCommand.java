package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.schedule.Appointment;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Deletes an existing appointment in the schedule
 */
public class DelAppCommand extends Command {

    public static final String COMMAND_WORD = "delApp";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an existing appointment from PlaceBook. "
            + "Parameters: "
            + "INDEX "
            + "Example: " + COMMAND_WORD + " "
            + "4";

    public static final String MESSAGE_SUCCESS = "Appointment deleted: %1$s";

    private final Index index;

    /**
     * Creates an AddAppCommand
     * @param index The index of the person to be met during the appointment
    //     * @param location The location of the appointment
    //     * @param date The date of the appointment
    //     * @param time The time of the appointment
    //     * @param description The description of the appointment
     */
    public DelAppCommand(Index index) {
        requireNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Appointment> lastShownList = model.getFilteredAppointmentList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_APPOINTMENT_DISPLAYED_INDEX);
        }

        Appointment appointmentToDelete = lastShownList.get(index.getZeroBased());
        model.deleteAppointment(appointmentToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, appointmentToDelete));
    }


}
