package seedu.address.storage;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.schedule.Appointment;

/**
 * Jackson-friendly version of {@link Appointment}.
 */
public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";

    private final JsonAdaptedPerson client;
    private final String location;
    private final String date;
    private final String description;
    private final String time;

    /**
     * Constructs a {@code JsonAdaptedAppointment} with the given appointment details.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("client") JsonAdaptedPerson client,
            @JsonProperty("location") String location, @JsonProperty("date") String date,
            @JsonProperty("description") String description, @JsonProperty("time") String time) {
        this.client = client;
        this.location = location;
        this.date = date;
        this.description = description;
        this.time = time;
    }

    /**
     * Converts a given {@code Appointment} into this class for Jackson use.
     */
    public JsonAdaptedAppointment(Appointment source) {
        client = new JsonAdaptedPerson(source.getClient());
        location = source.getLocation().toString();
        date = source.getDate().toString();
        description = source.getDescription();
        time = source.getTime().toString();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Appointment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Appointment toModelType() throws IllegalValueException {

        if (client == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Person.class.getSimpleName()));
        }
        final Person modelClient = client.toModelType();

        if (location == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(location)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Address modelLocation = new Address(location);

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    LocalDate.class.getSimpleName()));
        }
        String[] dateArgs = date.split("-");
        int year = Integer.parseInt(dateArgs[0]);
        int month = Integer.parseInt(dateArgs[1]);
        int day = Integer.parseInt(dateArgs[2]);
        final LocalDate modelDate = LocalDate.of(year, month, day);

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, String.class.getSimpleName()));
        }
        final String modelDescription = description;

        if (time == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    LocalTime.class.getSimpleName()));
        }
        String[] timeArgs = time.split(":");
        int hour = Integer.parseInt(timeArgs[0]);
        int minute = Integer.parseInt(timeArgs[1]);
        final LocalTime modelTime = LocalTime.of(hour, minute);

        return new Appointment(modelClient, modelLocation, modelDate, modelDescription, modelTime);
    }
}
