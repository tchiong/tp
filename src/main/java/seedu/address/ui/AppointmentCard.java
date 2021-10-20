package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.schedule.Appointment;

/**
 * An UI component that displays information of a {@code Appointment}.
 */
public class AppointmentCard extends UiPart<Region> {

    private static final String FXML = "AppointmentListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Appointment appointment;

    @FXML
    private HBox appointmentCardPane;
    @FXML
    private Label description;
    @FXML
    private Label id;
    @FXML
    private TitledPane person;
    @FXML
    private Label address;
    @FXML
    private Label date;
    @FXML
    private Label time;
    /**
     * Creates a {@code AppointmentCard} with the given {@code Appointment} and index to display.
     */
    public AppointmentCard(Appointment appointment, int displayedIndex) {
        super(FXML);
        this.appointment = appointment;
        id.setText(displayedIndex + ". ");
        description.setText(appointment.getDescription());
        address.setText(appointment.getLocation().value);
        date.setText(appointment.getDate().toString());
        time.setText(appointment.getTime().toString());
        Person client = appointment.getClients().asUnmodifiableObservableList().get(0);
        PersonCard clientDetail = new PersonCard(client, 0);
        // TODO: think about displayIndex when reusing PersonCard
        person.setText(client.getName().fullName);
        person.setContent(clientDetail.getRoot());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AppointmentCard)) {
            return false;
        }

        // state check
        AppointmentCard card = (AppointmentCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
