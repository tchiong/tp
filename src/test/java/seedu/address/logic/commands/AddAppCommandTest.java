package seedu.address.logic.commands;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AddAppCommandTest {

    @Test
    public void constructor_nullAppointment_throwsNullPointerException() {
        assertThrows(NullPointerException.class, ()
            -> new AddAppCommand(null, null, null, null, null));
    }
}
