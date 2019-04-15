import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.util.*;

public class TodoQuarter {
    private List<TodoItem> todoItems;  // list of TodoItem objects

    public TodoQuarter() {
        todoItems = new ArrayList<TodoItem>();

    }

    public void addItem(String title, LocalDate deadline) {
        TodoItem item = new TodoItem(title, deadline);
        todoItems.add(item);
    }

    public void removeItem(int index) {
        todoItems.remove(index);
    }

    public void archiveItems() {
        TodoItem singleItem;
        Iterator<TodoItem> listIterator = todoItems.iterator();
        while (listIterator.hasNext()) {
            singleItem = listIterator.next();
            if (singleItem.isDone()) {
                listIterator.remove();
            }
        }
    }

    public TodoItem getItem(int index) {
        return todoItems.get(index);
    }

    public List<TodoItem> getItems() {
        return todoItems;
    }

    @Override
    public String toString() {
        Comparator<TodoItem> compareByDate = new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                if (o1.getDeadline().isBefore(o2.getDeadline())) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(todoItems, compareByDate);

        String output = "";
        for (int i = 0; i < todoItems.size(); i++) {
            output += i + 1 + ". " + todoItems.get(i).toString()+"\n";
        }
        return output;
    }
}
