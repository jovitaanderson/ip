package duke.command;

import duke.DukeException;
import duke.Response;
import duke.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Unmarks a task at a specific index in tasklist.
 */
public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if (index > taskList.listSize()) {
            throw new DukeException("There is no " + index + " index in the list. \n");
        } else {
            taskList.unmarkTaskAtIndex(index - 1);
            String message = "[ ] I've marked this task as not done yet:\n" + taskList.getTaskAtIndex(index - 1) + "\n";
            Response response = new Response(message, false, false);
            ui.setResponse(response);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
