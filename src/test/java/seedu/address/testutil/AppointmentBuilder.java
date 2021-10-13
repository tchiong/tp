package seedu.address.testutil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.address.model.person.Address;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.Appointment;

/**
 * A utility class to help with building Person objects.
 */
public class AppointmentBuilder {

    public static final Person DEFAULT_PERSON = new PersonBuilder().build();
    public static final String DEFAULT_DESCRIPTION = "Team Meeting";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final LocalDate DEFAULT_DATE = LocalDate.of(2020, 12, 15);
    public static final LocalTime DEFAULT_TIME = LocalTime.of(20, 30);

    private Person client;
    private String description;
    private Address location;
    private LocalDate date;
    private LocalTime time;

    /**
     * Creates a {@code AppointmentBuilder} with the default details.
     */
    public AppointmentBuilder() {
        client = DEFAULT_PERSON;
        description = DEFAULT_DESCRIPTION;
        location = new Address(DEFAULT_ADDRESS);
        date = DEFAULT_DATE;
        time = DEFAULT_TIME;
    }

    /**
     * Initializes the AppointmentBuilder with the data of {@code appointmentToCopy}.
     */
    public AppointmentBuilder(Appointment appointmentToCopy) {
        client = appointmentToCopy.getClient();
        description = appointmentToCopy.getDescription();
        location = appointmentToCopy.getLocation();
        date = appointmentToCopy.getDate();
        time = appointmentToCopy.getTime();
    }

    /**
     * Sets the {@code Person} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withClient(Person client) {
        this.client = client;
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withLocation(String location) {
        this.location = new Address(location);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the {@code Date} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter);
        return this;
    }

    /**
     * Sets the {@code Time} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        this.time = LocalTime.parse(time, formatter);
        return this;
    }

    public Appointment build() {
        return new Appointment(client, location, date, description, time);
    }

}
