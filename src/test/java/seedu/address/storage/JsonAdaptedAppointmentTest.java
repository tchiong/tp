package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedAppointment.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAppointment.ALICE_APPOINTMENT;
import static seedu.address.testutil.TypicalAppointment.ALICE_CARL_APPOINTMENT;
import static seedu.address.testutil.TypicalPersons.ALICE;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;

public class JsonAdaptedAppointmentTest {
    private static final String INVALID_LOCATION = null;
    private static final String INVALID_DATE = null;
    private static final String INVALID_TIME = null;
    private static final String INVALID_DESC = null;

    private static final String VALID_LOCATION = "vivocity";
    private static final String VALID_DATE = "2021-01-01";
    private static final String VALID_TIME = "20:30";
    private static final String VALID_DESC = "Testing";

    @Test
    public void toModelType_validSinglePersonAppointmentDetails_returnsAppointment() throws Exception {
        JsonAdaptedAppointment appointment = new JsonAdaptedAppointment(ALICE_APPOINTMENT);
        assertEquals(ALICE_APPOINTMENT, appointment.toModelType());
    }

    @Test
    public void toModelType_validMultiplePersonAppointmentDetails_returnsAppointment() throws Exception {
        JsonAdaptedAppointment appointment = new JsonAdaptedAppointment(ALICE_CARL_APPOINTMENT);
        assertEquals(ALICE_CARL_APPOINTMENT, appointment.toModelType());
    }

    @Test
    public void toModelType_invalidLocation_returnsAppointment() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(ALICE);
        List<JsonAdaptedPerson> clients = new ArrayList<>();
        clients.add(person);
        JsonAdaptedAppointment appointment =
                new JsonAdaptedAppointment(
                        clients,
                        INVALID_LOCATION, VALID_DATE, VALID_DESC, VALID_TIME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, appointment::toModelType);
    }

    @Test
    public void toModelType_invalidDate_returnsAppointment() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(ALICE);
        List<JsonAdaptedPerson> clients = new ArrayList<>();
        clients.add(person);
        JsonAdaptedAppointment appointment =
                new JsonAdaptedAppointment(
                        clients,
                        VALID_LOCATION, INVALID_DATE, VALID_DESC, VALID_TIME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, LocalDate.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, appointment::toModelType);
    }

    @Test
    public void toModelType_invalidDesc_returnsAppointment() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(ALICE);
        List<JsonAdaptedPerson> clients = new ArrayList<>();
        clients.add(person);
        JsonAdaptedAppointment appointment =
                new JsonAdaptedAppointment(
                        clients,
                        VALID_LOCATION, VALID_DATE, INVALID_DESC, VALID_TIME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, String.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, appointment::toModelType);
    }

    @Test
    public void toModelType_invalidTime_returnsAppointment() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(ALICE);
        List<JsonAdaptedPerson> clients = new ArrayList<>();
        clients.add(person);
        JsonAdaptedAppointment appointment =
                new JsonAdaptedAppointment(
                        clients,
                        VALID_LOCATION, VALID_DATE, VALID_DESC, INVALID_TIME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, LocalTime.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, appointment::toModelType);
    }
}
