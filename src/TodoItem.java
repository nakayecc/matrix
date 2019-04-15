import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodoItem {
    private String title; // title of todoItem
    private LocalDate deadline;  // deadline of todoItem, year is always set to 2018
    private boolean isDone;

    public TodoItem(String title, LocalDate deadline) {
        this.title = title;
        this.deadline = deadline;
        this.isDone = false;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
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
        String date = deadline.format(DateTimeFormatter.ofPattern("d-M"));
        String mark = "";
        if (isDone) {
            mark = "[x]";
        } else {
            mark = "[ ]";
        }
        return mark + " " + date + " " + this.title;
    }

    public boolean isDone() {
        return isDone;
    }

}


