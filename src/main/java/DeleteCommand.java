public class DeleteCommand extends Command{
    private int index;

    public DeleteCommand(int index) {
        this.index= index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if(index > taskList.listSize()){
            throw new DukeException("There is no " + index + " index in the list. （ﾟДﾟ ）\n");
        } else {
            Task curr = taskList.getTaskAtIndex(index -1);
            taskList.removeTaskAtIndex(index-1);
            ui.printMessage(" - Removed this task:\n" + curr + "\nNow you have " + taskList.listSize()
                    + " tasks in the list\n");
        }
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
