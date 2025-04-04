package seedu.address.logic.commands;


import static seedu.address.logic.Messages.MESSAGE_EMPTY_STUDENT_LIST;
import static seedu.address.logic.Messages.MESSAGE_LIST_SUCCESS;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, MESSAGE_LIST_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, Index.fromOneBased(1));
        assertCommandSuccess(new ListCommand(), model, MESSAGE_LIST_SUCCESS, expectedModel);
    }

    @Test
    public void execute_emptyStudentList_throwsCommandException() {
        model = new ModelManager(); // Creates an empty model with no students
        assertCommandFailure(new ListCommand(), model, MESSAGE_EMPTY_STUDENT_LIST);
    }
}
