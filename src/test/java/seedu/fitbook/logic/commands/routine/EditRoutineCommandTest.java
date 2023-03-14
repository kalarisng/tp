package seedu.fitbook.logic.commands.routine;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.fitbook.logic.commands.CommandTestUtil.DESC_CARDIO;
import static seedu.fitbook.logic.commands.CommandTestUtil.DESC_STRENGTH;
import static seedu.fitbook.logic.commands.CommandTestUtil.VALID_ROUTINE_NAME_STRENGTH;
import static seedu.fitbook.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.fitbook.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.fitbook.testutil.TypicalIndexes.INDEX_FIRST_ROUTINE;
import static seedu.fitbook.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.fitbook.testutil.TypicalIndexes.INDEX_SECOND_ROUTINE;
import static seedu.fitbook.testutil.client.TypicalClients.getTypicalFitBook;
import static seedu.fitbook.testutil.routine.TypicalRoutines.getTypicalFitBookExerciseRoutine;

import org.junit.jupiter.api.Test;

import seedu.fitbook.commons.core.Messages;
import seedu.fitbook.commons.core.index.Index;
import seedu.fitbook.logic.commands.ClearCommand;
import seedu.fitbook.logic.commands.EditRoutineCommand;
import seedu.fitbook.logic.commands.EditRoutineCommand.EditRoutineDescriptor;
import seedu.fitbook.model.FitBook;
import seedu.fitbook.model.FitBookExerciseRoutine;
import seedu.fitbook.model.FitBookModel;
import seedu.fitbook.model.FitBookModelManager;
import seedu.fitbook.model.UserPrefs;
import seedu.fitbook.model.routines.Routine;
import seedu.fitbook.testutil.routine.EditRoutineDescriptorBuilder;

/**
 * Contains integration tests (interaction with the FitBookModel) and unit tests for EditCommand.
 */
public class EditRoutineCommandTest {

    private FitBookModel model = new FitBookModelManager(getTypicalFitBook(),
            getTypicalFitBookExerciseRoutine(), new UserPrefs());

    //TODO Find function needs to be implemented first
    /*
    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        Routine editedRoutine = new RoutineBuilder().build();
        EditRoutineDescriptor descriptor = new EditRoutineDescriptorBuilder(editedRoutine).build();
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(INDEX_FIRST_ROUTINE, descriptor);

        String expectedMessage = String.format(EditRoutineCommand.MESSAGE_EDIT_ROUTINE_SUCCESS, editedRoutine);

        FitBookModel expectedFitBookExerciseRoutineModel = new FitBookModelManager(new FitBook(model.getFitBook()),
                new FitBookExerciseRoutine(model.getFitBookExerciseRoutine()), new UserPrefs());
        expectedFitBookExerciseRoutineModel.setRoutine(model.getFilteredRoutineList().get(0), editedRoutine);

        assertCommandSuccess(editRoutineCommand, model, expectedMessage, expectedFitBookExerciseRoutineModel);
    }
    */

    //TODO Find function needs to be implemented first
    /*
    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        Index indexLastRoutine = Index.fromOneBased(model.getFilteredRoutineList().size());
        Routine lastRoutine = model.getFilteredRoutineList().get(indexLastRoutine.getZeroBased());

        RoutineBuilder routineInList = new RoutineBuilder(lastRoutine);
        Routine editedRoutine = routineInList.withRoutineName(VALID_ROUTINE_NAME_STRENGTH)
                .withExercises(VALID_EXERCISE_SITUP).build();

        EditRoutineDescriptor descriptor = new EditRoutineDescriptorBuilder()
                .withRoutineName(VALID_ROUTINE_NAME_STRENGTH).withExercise(VALID_EXERCISE_SITUP)
                .build();
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(indexLastRoutine, descriptor);

        String expectedMessage = String.format(EditRoutineCommand.MESSAGE_EDIT_ROUTINE_SUCCESS, editedRoutine);

        FitBookModel expectedFitBookModel = new FitBookModelManager(new FitBook(model.getFitBook()),
                new FitBookExerciseRoutine(model.getFitBookExerciseRoutine()), new UserPrefs());
        expectedFitBookModel.setRoutine(lastRoutine, editedRoutine);

        assertCommandSuccess(editRoutineCommand, model, expectedMessage, expectedFitBookModel);
    }
     */

    @Test
    public void execute_noFieldSpecifiedUnfilteredList_success() {
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(INDEX_FIRST_ROUTINE,
                new EditRoutineDescriptor());
        Routine editedRoutine = model.getFilteredRoutineList().get(INDEX_FIRST_ROUTINE.getZeroBased());

        String expectedMessage = String.format(EditRoutineCommand.MESSAGE_EDIT_ROUTINE_SUCCESS, editedRoutine);

        FitBookModel expectedFitBookModel = new FitBookModelManager(new FitBook(model.getFitBook()),
                new FitBookExerciseRoutine(model.getFitBookExerciseRoutine()), new UserPrefs());

        assertCommandSuccess(editRoutineCommand, model, expectedMessage, expectedFitBookModel);
    }

    //TODO Find function needs to be implemented first
    /*
    @Test
    public void execute_filteredList_success() {
        showRoutineAtIndex(model, INDEX_FIRST_ROUTINE);

        Routine routineInFilteredList = model.getFilteredRoutineList().get(INDEX_FIRST_ROUTINE.getZeroBased());
        Routine editedRoutine = new RoutineBuilder(routineInFilteredList).withRoutineName(VALID_ROUTINE_NAME_CARDIO)
                .build();
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(INDEX_FIRST_ROUTINE,
                new EditRoutineDescriptorBuilder().withRoutineName(VALID_ROUTINE_NAME_STRENGTH).build());

        String expectedMessage = String.format(EditRoutineCommand.MESSAGE_EDIT_ROUTINE_SUCCESS, editedRoutine);

        FitBookModel expectedFitBookModel = new FitBookModelManager(new FitBook(model.getFitBook()),
                new FitBookExerciseRoutine(model.getFitBookExerciseRoutine()), new UserPrefs());
        expectedFitBookModel.setRoutine(model.getFilteredRoutineList().get(0), editedRoutine);

        assertCommandSuccess(editRoutineCommand, model, expectedMessage, expectedFitBookModel);
    }
     */

    @Test
    public void execute_duplicateRoutineUnfilteredList_failure() {
        Routine firstRoutine = model.getFilteredRoutineList().get(INDEX_FIRST_ROUTINE.getZeroBased());
        EditRoutineDescriptor descriptor = new EditRoutineDescriptorBuilder(firstRoutine).build();
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(INDEX_SECOND_ROUTINE, descriptor);

        assertCommandFailure(editRoutineCommand, model, EditRoutineCommand.MESSAGE_DUPLICATE_ROUTINE);
    }

    //TODO Find function needs to be implemented first
    /*
    @Test
    public void execute_duplicateRoutineFilteredList_failure() {
        showRoutineAtIndex(model, INDEX_FIRST_ROUTINE);

        // edit routine in filtered list into a duplicate in FitBook
        Routine routineInList = model.getFitBookExerciseRoutine()
                .getRoutineList().get(INDEX_SECOND_ROUTINE.getZeroBased());
        EditRoutineCommand editRoutineCommand = new EditRoutineCommand(INDEX_FIRST_ROUTINE,
                new EditRoutineDescriptorBuilder(routineInList).build());

        assertCommandFailure(editRoutineCommand, model, EditRoutineCommand.MESSAGE_DUPLICATE_ROUTINE);
    }
     */

    @Test
    public void execute_invalidRoutineIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRoutineList().size() + 1);
        EditRoutineDescriptor descriptor = new EditRoutineDescriptorBuilder()
                .withRoutineName(VALID_ROUTINE_NAME_STRENGTH).build();
        EditRoutineCommand editCommand = new EditRoutineCommand(outOfBoundIndex, descriptor);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_ROUTINE_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of FitBook
     */
    //TODO Find function needs to be implemented first
    /*
    @Test
    public void execute_invalidRoutineIndexFilteredList_failure() {
        showRoutineAtIndex(model, INDEX_FIRST_ROUTINE);
        Index outOfBoundIndex = INDEX_SECOND_ROUTINE;
        // ensures that outOfBoundIndex is still in bounds of FitBook list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getFitBookExerciseRoutine().getRoutineList().size());

        EditRoutineCommand editCommand = new EditRoutineCommand(outOfBoundIndex,
                new EditRoutineDescriptorBuilder().withRoutineName(VALID_ROUTINE_NAME_STRENGTH).build());

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_ROUTINE_DISPLAYED_INDEX);
    }
     */

    @Test
    public void equals() {
        final EditRoutineCommand standardCommand = new EditRoutineCommand(INDEX_FIRST_ROUTINE, DESC_CARDIO);

        // same values -> returns true
        EditRoutineDescriptor copyDescriptor = new EditRoutineDescriptor(DESC_CARDIO);
        EditRoutineCommand commandWithSameValues = new EditRoutineCommand(INDEX_FIRST_ROUTINE, copyDescriptor);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new EditRoutineCommand(INDEX_SECOND_PERSON, DESC_CARDIO)));

        // different descriptor -> returns false
        assertFalse(standardCommand.equals(new EditRoutineCommand(INDEX_FIRST_ROUTINE, DESC_STRENGTH)));
    }

}