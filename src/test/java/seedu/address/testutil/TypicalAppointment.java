package seedu.address.testutil;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.CARL;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.AddressBookTest;
import seedu.address.model.person.Address;
import seedu.address.model.schedule.Appointment;

public class TypicalAppointment {
    public static final Appointment ALICE_APPOINTMENT = new AppointmentBuilder()
            .withClient(ALICE)
            .withLocation("369 Tanjong Rhu")
            .withDate("25-12-2021")
            .withTime("2130")
            .withDescription("Talk about sales")
            .build();

    public static final Appointment CARL_APPOINTMENT = new AppointmentBuilder()
            .withClient(CARL)
            .withLocation("vivocity")
            .withDate("31-10-2021")
            .withTime("1930")
            .withDescription("Halloween Sales")
            .build();

    public static List<Appointment> getTypicalAppointments() {
        return new ArrayList<>(Arrays.asList(ALICE_APPOINTMENT, CARL_APPOINTMENT));
    }

    public static AddressBook getTypicalAddressBook() {
        AddressBook addressBook = new AddressBook();
        for(Appointment appointment : getTypicalAppointments()) {
            addressBook.addAppointment(appointment);
        }
        return addressBook;
    }

    public static AddressBook getTypicalAddressBook(AddressBook addressBook) {
        for(Appointment appointment : getTypicalAppointments()) {
            addressBook.addAppointment(appointment);
        }
        return addressBook;
    }
}
