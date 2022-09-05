package duke;

import java.time.LocalDate;

import duke.command.*;

/**
 * Parses the user input and executes the corresponding commands.
 */
public class Parser {
    /**
     * Returns Command object based on user's input.
     * @param fullCommand user's input.
     * @return specific command.
     * @throws DukeException If command does not exist.
     */
    public static Command parse(String fullCommand) throws DukeException {
        String[] commandSegments = fullCommand.split(" ", 2);
        String mainCommand = commandSegments[0].toLowerCase().trim();

        switch (mainCommand) {
        case "list":
            return new ListCommand();
        case "bye":
            return new ByeCommand();
        case "help":
            return new HelpCommand();
        case "todo":
            assert (commandSegments[1] != null) : "Missing task name";
            return new TodoCommand(commandSegments[1].trim());
        case "deadline":
            assert (commandSegments[1].contains("/by")) : "Input has missing keyword /\"by\"";
            String[] deadlineSegments = commandSegments[1].split("/by", 2);
            return new DeadlineCommand(deadlineSegments[0], LocalDate.parse(deadlineSegments[1].trim()));
        case "event":
            assert (commandSegments[1].contains("/at")) : "Input has missing keyword /\"at\"";
            String[] eventSegments = commandSegments[1].split("/at", 2);
            return new EventCommand(eventSegments[0], eventSegments[1]);
        case "mark":
            assert (commandSegments[1] != null) : "Missing index";
            return new MarkCommand(Integer.parseInt(commandSegments[1].trim()));
        case "unmark":
            assert (commandSegments[1] != null) : "Missing index";
            return new UnmarkCommand(Integer.parseInt(commandSegments[1].trim()));
        case "delete":
            assert (commandSegments[1] != null) : "Missing index";
            return new DeleteCommand(Integer.parseInt(commandSegments[1].trim()));
        case "find":
            assert (commandSegments[1] != null) : "Missing find keyword";
            return new FindCommand(commandSegments[1].trim());
        default:
            throw new DukeException(mainCommand + "? I don't know what that means\n");
        }
    }
}
