package seedu.address.storage;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.UniquePersonList;
import seedu.address.model.schedule.Appointment;
import seedu.address.model.schedule.TimePeriod;

/**
 * Jackson-friendly version of {@link Appointment}.
 */
public class JsonAdaptedAppointment {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Appointment's %s field is missing!";
    public static final String MESSAGE_DUPLICATE_PERSON = "Client list contains duplicate person(s).";

    private final List<JsonAdaptedPerson> clients = new ArrayList<>();
    private final String location;
    private final String timePeriod;
    private final String description;

    /**
     * Constructs a {@code JsonAdaptedAppointment} with the given appointment details.
     */
    @JsonCreator
    public JsonAdaptedAppointment(@JsonProperty("clients") List<JsonAdaptedPerson> clients,
            @JsonProperty("location") String location, @JsonProperty("timePeriod") String timePeriod,
            @JsonProperty("description") String description) {
        this.clients.addAll(clients);
        this.location = location;
        this.timePeriod = timePeriod;
        this.description = description;
    }

    /**
     * Converts a given {@code Appointment} into this class for Jackson use.
     */
    public JsonAdaptedAppointment(Appointment source) {
        clients.addAll(source.getClientList().stream().map(JsonAdaptedPerson::new).collect(Collectors.toList()));
        location = source.getLocation().toString();
        timePeriod = source.getTimePeriod().toString();
        description = source.getDescription();
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Appointment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Appointment toModelType() throws IllegalValueException {

        if (clients == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Person.class.getSimpleName()));
        }
        final UniquePersonList modelClients = createModelClient(this.clients);

        if (location == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(location)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Address modelLocation = new Address(location);

        if (timePeriod == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    LocalDate.class.getSimpleName()));
        }
        String[] timePeriodArgs = timePeriod.split("-");
        LocalDateTime startDateTime = LocalDateTime.parse(timePeriodArgs[0]);
        LocalDateTime endDateTime = LocalDateTime.parse(timePeriodArgs[1]);
        final TimePeriod modelTimePeriod = new TimePeriod(startDateTime, endDateTime);

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, String.class.getSimpleName()));
        }
        final String modelDescription = description;

        return new Appointment(modelClients, modelLocation, modelTimePeriod, modelDescription);
    }

    private UniquePersonList createModelClient(List<JsonAdaptedPerson> clients) throws IllegalValueException {
        UniquePersonList modelClients = new UniquePersonList();
        for (JsonAdaptedPerson jsonAdaptedPerson : clients) {
            Person person = jsonAdaptedPerson.toModelType();
            if (modelClients.contains(person)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            modelClients.add(person);
        }
        return modelClients;
    }
}
