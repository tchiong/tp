package seedu.address.testutil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.address.model.person.Address;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.Appointment;

/**
 * A utility class to help with building Appointment Objects.
 */
public class AppointmentBuilder {
    private static final String DEFAULT_CLIENT = "ALICE";
    private static final String DEFAULT_LOCATION = "vivocity";
    private static final String DEFAULT_DATE = "01-01-2021";
    private static final String DEFAULT_TIME = "1800";
    private static final String DEFAULT_DESCRIPTION = "Halloween Sales";

    private Person client;
    private Address location;
    private LocalDate date;
    private LocalTime time;
    private String description;

    /**
     * Creates a {@code} AppointmentBuilder with the default details.
     */
    public AppointmentBuilder() {
        this.client = new PersonBuilder().withName(DEFAULT_CLIENT).build();
        this.location = new Address(DEFAULT_LOCATION);
        this.date = LocalDate.parse(DEFAULT_DATE, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.time = LocalTime.parse(DEFAULT_TIME, DateTimeFormatter.ofPattern("HHmm"));
        this.description = DEFAULT_DESCRIPTION;
    }

    /**
     * Initializes the AppointmentBuilder with the data of {@code appointmentToCopy}.
     * @param appointmentToCopy The given appointment to copy.
     */
    public AppointmentBuilder(Appointment appointmentToCopy) {
        this.client = appointmentToCopy.getClient();
        this.location = appointmentToCopy.getLocation();
        this.date = appointmentToCopy.getDate();
        this.time = appointmentToCopy.getTime();
        this.description = appointmentToCopy.getDescription();
    }

    /**
     * Sets the {@code client} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withClient(Person client) {
        this.client = client;
        return this;
    }

    /**
     * Sets the {@code client} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withClient(String clientName) {
        this.client = new PersonBuilder().withName(clientName).build();
        return this;
    }

    /**
     * Sets the {@code location} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withLocation(String location) {
        this.location = new Address(location);
        return this;
    }

    /**
     * Sets the {@code date} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this;
    }

    /**
     * Sets the {@code time} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withTime(String time) {
        this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("HHmm"));
        return this;
    }

    /**
     * Sets the {@code description} of the {@code Appointment} that we are building.
     */
    public AppointmentBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public Appointment build() {
        return new Appointment(client, location, date, description, time);
    }
}
