import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodoItem {
    private String title; // title of todoItem
    private LocalDate deadline;  // deadline of todoItem, year is always set to 2018
    boolean isDone;       // contains true if TODO item is done, otherwise contains false. Default value is false

    public TodoItem(String title, LocalDate deadline) {
        this.title = title;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadLine() {
        return deadline;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        String date = deadline.format(DateTimeFormatter.ofPattern("dd-M"));
        String mark = "";
        if (isDone) {
            mark = "[X]";
        } else {
            mark = "[ ]";
        }
        return mark + " " + date + " " + this.title;
    }
}


