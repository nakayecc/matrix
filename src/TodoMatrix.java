import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TodoMatrix {
    private Map<String, TodoQuarter> tdO;

    public TodoMatrix() {
        tdO = new HashMap<String, TodoQuarter>();
        tdO.put("IU", new TodoQuarter());
        tdO.put("IN", new TodoQuarter());
        tdO.put("NU", new TodoQuarter());
        tdO.put("NN", new TodoQuarter());
    }

    public Map<String, TodoQuarter> getQuarters() {
        return tdO;
    }

    public TodoQuarter getQuarter(String status) {
        return tdO.get(status);
    }

    public void addItem(String title, LocalDate deadline) {
        LocalDate today = LocalDate.now();
        Period timeToDeadline = Period.between(today, deadline);
        if (!deadline.minusDays(3).isAfter(today)) {
            tdO.get("NU").addItem(title, deadline);
        } else {
            tdO.get("NN").addItem(title, deadline);

        }
    }

    public void addItem(String title, LocalDate deadline, boolean isImportant) {
        LocalDate today = LocalDate.now();
        Period timeToDeadline = Period.between(today, deadline);
        if (isImportant) {
            if (!deadline.minusDays(3).isAfter(today)) {
                tdO.get("IU").addItem(title, deadline);
            } else {
                tdO.get("IN").addItem(title, deadline);
            }
        } else {
            addItem(title, deadline);
        }
    }

    public void archiveItems() {
        tdO.get("IU").archiveItems();
        tdO.get("IN").archiveItems();
        tdO.get("NU").archiveItems();
        tdO.get("NN").archiveItems();

    }

    public void saveItemsToFile(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Map.Entry<String, TodoQuarter> entry : tdO.entrySet()) {
                if (entry.getKey() == "IU" || entry.getKey() == "IN") {
                    for (TodoItem todoItem : entry.getValue().getItems()) {
                        writer.write(todoItem.getTitle() + "  |" + todoItem.getDeadline().format(formatter) +
                                "| " + "important" + "\n");

                    }

                } else if (entry.getKey() == "NU" || entry.getKey() == "NN") {
                    for (TodoItem todoItem : entry.getValue().getItems()) {
                        writer.write(todoItem.getTitle() + "  |" + todoItem.getDeadline().format(formatter) + "| " + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addItemsFromFile(String fileName) {
        LocalDate ld;
        int taskIndex = 0;
        int dateIndex = 1;
        int dayIndex = 0;
        int monthIndex = 1;
        try {
            Scanner reader = new Scanner(new File(fileName));

            while (reader.hasNext()) {
                String[] singleRecord = reader.nextLine().split("\\|");
                String[] date = singleRecord[dateIndex].split("-");
                ld = LocalDate.of(2018, Integer.parseInt(date[monthIndex]), Integer.parseInt(date[dayIndex]));
                if (singleRecord.length == 3) {
                    addItem(singleRecord[taskIndex], ld, true);
                } else {
                    addItem(singleRecord[taskIndex], ld);
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Override
    public String toString() {
        return "                 IU                               |                                 IN     \n"+tdO.get("IU") + "                       " + tdO.get("IN")  +"\n"+ "---------------------------------------------------\n"
                +"                NU                              |                                 NN     \n"+ tdO.get("NU") + "                       " + tdO.get("NN");
    }
}

