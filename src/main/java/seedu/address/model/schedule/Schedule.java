package seedu.address.model.schedule;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.schedule.exceptions.AppointmentNotFoundException;

/**
 * A list of Appointments
 *
 * Supports a minimal set of list operations.
 */
public class Schedule implements Iterable<Appointment> {
    // Data Fields
    private final ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
    private final ObservableList<Appointment> appointmentListUnModifiable =
            FXCollections.unmodifiableObservableList(appointmentList);

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Appointment> asUnmodifiableObservableList() {
        return appointmentListUnModifiable;
    }

    /**
     * Adds an Appointment to the list.
     */
    public void add(Appointment toAdd) {
        requireNonNull(toAdd);
        appointmentList.add(toAdd);
    }

    /**
     * Removes the equivalent Appointment from the list.
     * The Appointment must exist in the list.
     */
    public void remove(Appointment toRemove) {
        requireNonNull(toRemove);
        if (!appointmentList.remove(toRemove)) {
            throw new AppointmentNotFoundException();
        }
    }

    /**
     * Check if appointmentList contains {@code Appointment}
     * @return boolean result
     */
    public boolean contains(Appointment toCheck) {
        requireNonNull(toCheck);
        return appointmentList.contains(toCheck);
    }

    @Override
    public Iterator<Appointment> iterator() {
        return appointmentList.iterator();
    }

    @Override
    public int hashCode() {
        return appointmentList.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Schedule // instanceof handles nulls
                && appointmentList.equals(((Schedule) other).appointmentList));
    }

}
