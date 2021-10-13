package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.schedule.Appointment;

public interface ReadOnlySchedule {

    /**
     * Returns an unmodifiable view of the appointments list.
     * This list will not contain any duplicate appointments.
     */
    ObservableList<Appointment> getSchedule();
}
