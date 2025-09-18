package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import seedu.address.model.person.Remark;

public class RemarkCommandTest {

    private final Model model = new ModelManager();

    @Test
    public void execute_invalidIndex_failure() {
        Model emptyModel = new ModelManager();
        // Use an index that is out of bounds for the empty model
        assertCommandFailure(new RemarkCommand(INDEX_FIRST_PERSON, new Remark("hello")),
                emptyModel, seedu.address.logic.Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }
}
