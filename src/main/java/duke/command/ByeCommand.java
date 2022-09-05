package duke.command;

import duke.Constants;
import duke.DukeException;
import duke.Ui;
import duke.storage.Storage;
import duke.task.TaskList;

/**
 * Terminates the program.
 */
public class ByeCommand extends Command {
    public ByeCommand() {
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.setResponse(Constants.BYE_MESSAGE);
        storage.saveTasksInStorage(taskList.getList());
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
