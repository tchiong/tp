package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalPersons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.testutil.TypicalAppointment;
import seedu.address.testutil.TypicalPersons;

class ListAppCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        AddressBook typicalAddressBookWithPersons = TypicalPersons.getTypicalAddressBook();
        AddressBook typicalAddressBookWithPersonsAndAppointments = TypicalAppointment.getTypicalAddressBook(
                typicalAddressBookWithPersons
        );
        model = new ModelManager(
                typicalAddressBookWithPersonsAndAppointments,
                new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
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