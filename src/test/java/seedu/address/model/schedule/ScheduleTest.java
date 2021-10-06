package seedu.address.model.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAppointment.ALICE_APPOINTMENT;

import org.junit.jupiter.api.Test;

import seedu.address.model.schedule.exceptions.AppointmentNotFoundException;

public class ScheduleTest {

    private final Schedule schedule = new Schedule();

    @Test
    public void add_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.add(null));
    }

    @Test
    public void remove_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.remove(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPersonNotFoundException() {
        assertThrows(AppointmentNotFoundException.class, () -> schedule.remove(ALICE_APPOINTMENT));
    }

    @Test
    public void remove_existingPerson_removesPerson() {
        schedule.add(ALICE_APPOINTMENT);
        schedule.remove(ALICE_APPOINTMENT);
        Schedule expectedSchedule = new Schedule();
        assertEquals(expectedSchedule, schedule);
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> schedule.asUnmodifiableObservableList().remove(0));
    }
}
