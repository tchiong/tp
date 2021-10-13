package seedu.address.model.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAppointment.ALICE_APPOINTMENT;

import org.junit.jupiter.api.Test;

import seedu.address.model.schedule.exceptions.AppointmentNotFoundException;

public class ScheduleTest {

    private final Schedule schedule = new Schedule();

    @Test
    public void add_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.addAppointment(null));
    }

    @Test
    public void add_existingPerson() {
        schedule.addAppointment(ALICE_APPOINTMENT);
        assertTrue(schedule.contains(ALICE_APPOINTMENT));
    }

    @Test
    public void remove_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> schedule.deleteAppointment(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPersonNotFoundException() {
        assertThrows(AppointmentNotFoundException.class, () -> schedule.deleteAppointment(ALICE_APPOINTMENT));
    }

    @Test
    public void remove_existingPerson_removesPerson() {
        schedule.addAppointment(ALICE_APPOINTMENT);
        schedule.deleteAppointment(ALICE_APPOINTMENT);
        Schedule expectedSchedule = new Schedule();
        assertEquals(expectedSchedule, schedule);
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> schedule.asUnmodifiableObservableList().remove(0));
    }
}
