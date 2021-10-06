package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.CARL;

import java.time.LocalDate;
import java.time.LocalTime;

import seedu.address.model.person.Address;
import seedu.address.model.schedule.Appointment;

public class TypicalAppointment {

    public static final Appointment ALICE_APPOINTMENT = new Appointment(ALICE
            , new Address("369 Tanjong Rhu")
            , LocalDate.of(2021, 12, 25)
            , "Talk about sales");
    public static final Appointment CARL_APPOINTMENT = new Appointment(CARL
            , new Address("Vivocity")
            , LocalDate.of(2021, 10, 31)
            , "Halloween Sales"
            , LocalTime.of(19, 30));
}
