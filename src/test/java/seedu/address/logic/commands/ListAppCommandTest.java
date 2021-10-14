package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.schedule.Schedule;
import seedu.address.testutil.TypicalAppointment;
import seedu.address.testutil.TypicalPersons;

class ListAppCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        AddressBook addressBook = TypicalPersons.getTypicalAddressBook();
        Schedule schedule = TypicalAppointment.getTypicalSchedule();
        model = new ModelManager(addressBook, new UserPrefs(), schedule);
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getSchedule());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListAppCommand(), model, ListAppCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        model.updateFilteredAppointmentList(x -> false);
        assertCommandSuccess(new ListAppCommand(), model, ListAppCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
