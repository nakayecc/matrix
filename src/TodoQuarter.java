import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoQuarter {
    private List<Object> todoItems;  // list of TodoItem objects

    public TodoQuarter()  {
        todoItems = new ArrayList<Object>();

    }

    public void addItem(String title, LocalDate deadline) {
        TodoItem item = new TodoItem(title, deadline);
        todoItems.add(item);
    }

    public void removeItem(int index) {
        todoItems.remove(index);
    }

    public void archiveItems() {
        String singleItem;
        Iterator<Object> listIterator = todoItems.iterator();
        while (listIterator.hasNext()) {
            singleItem = listIterator.next().toString();
            if (singleItem.substring(0, 3).equals("[ ]")) {
                listIterator.remove();
            }
        }
    }

    public Object getItem(int index) {  // return object
        return todoItems.get(index);
    }

    public String getItems(){
        


        return "";
    }

    @Override
    public String toString() {
        Object singleItem;
        Iterator<Object> listIterator = todoItems.iterator();
        while (listIterator.hasNext()) {
            singleItem = listIterator.next();
            System.out.println(singleItem);

        }
        return todoItems.toString();

    }
}
