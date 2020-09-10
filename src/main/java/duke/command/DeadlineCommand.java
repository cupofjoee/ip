package duke.command;

import duke.Parser;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;
import duke.task.Task;
import duke.exception.EmptyDescriptionException;
import duke.exception.InvalidFormatException;

/**
 * Represents a deadline command.
 */
public class DeadlineCommand implements Command {

    /**
     * Parses the input to extract the details: title and by.
     * Creates the Deadline object.
     * Adds it to the user data.
     * Notifies user that it has been executed.
     *
     * @param taskList
     * @param ui
     * @param input
     * @throws EmptyDescriptionException
     * @throws InvalidFormatException
     * @return
     */
    @Override
    public String execute(TaskList taskList, Ui ui, String input) throws EmptyDescriptionException, InvalidFormatException {
        String[] details = Parser.parseDeadline(input);
        String title = details[0];
        String by = details[1];
        Task task = new Deadline(title, by);
        taskList.add(task);
        return ui.add(task);
    }
}
