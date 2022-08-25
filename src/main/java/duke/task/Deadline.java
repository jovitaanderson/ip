package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected String by;
    private LocalDate date;
    private String formattedDate;

    public Deadline(String description, LocalDate date) {
        super(description);
        this.date = date;
        this.formattedDate = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
    }

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by:" + formattedDate + ")";
    }


    //when saved and loaded again it will return a null date
    @Override
    public String toStringForStorage() {
        return "D|" + super.toStringForStorage() + "|" + date.toString();
    }
}
