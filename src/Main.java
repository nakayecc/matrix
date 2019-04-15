import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate ld;
        int year = 2019;
        int month = 12;
        int day = 3;

        ld = LocalDate.of(2019, month, day);
        TodoItem td = new TodoItem("kupic mleko", ld);
        td.mark();


        TodoQuarter tdQ = new TodoQuarter();
        TodoMatrix tdM = new TodoMatrix();

/*
        ld = LocalDate.of(2018, 12, 3);
        tdQ.addItem("kupic chleb", ld);
        ld = LocalDate.of(2018, 11, 2);
        td.mark();
        tdQ.addItem("kupic mleko", ld);
        ld = LocalDate.of(2018, 12, 1);
        tdQ.addItem("kupic koc", ld);;
        tdQ.getItem(2).mark();
        tdQ.getItem(0).mark();
        //tdQ.archiveItems();
        System.out.println(tdQ);
*/

 /*       String title = "implement Quarter class";
        List<LocalDate> deadlines = new ArrayList<LocalDate>();
        deadlines.add(LocalDate.of(2017, Month.JUNE, 14));
        deadlines.add(LocalDate.of(2017, Month.MAY, 24));
        deadlines.add(LocalDate.of(2017, Month.JUNE, 4));
        deadlines.add(LocalDate.of(2017, Month.JULY, 3));
        deadlines.add(LocalDate.of(2017, Month.JUNE, 23));

        for (LocalDate deadline : deadlines) {
            tdQ.addItem(title, deadline);
        }

        System.out.println(tdQ);*/

        /*tdM.addItemsFromFile("sss");
        System.out.println(tdM);*/
/*
        System.out.println();
        //System.out.println("=-------------------------------------=");
        ld = LocalDate.of(year, 4, 1);
        tdM.addItem("Kupic mleko", ld);
        ld = LocalDate.of(year, 4, 7);
        tdM.addItem("Kupic keczup bez laktozy", ld);
        ld = LocalDate.of(year, 4, 7);
        tdM.addItem("Kupic mleko bez laktozy2", ld);
        ld = LocalDate.of(year, 4, 7);
        tdM.addItem("Rachunek za prąd", ld, false);
        ld = LocalDate.of(year, 4, 1);
        tdM.addItem("Rachunek za wode", ld, true);

        System.out.println(tdM) ;

        System.out.println(tdQ);
*/
    /*    LocalDate today = LocalDate.now();
        LocalDate urgent = LocalDate.now().plusDays(1);
        LocalDate notUrgent = LocalDate.now().plusDays(32);
        Period b = Period.between(today, urgent);
        Period d = Period.between(today, notUrgent);

        System.out.println(d.getDays());
        System.out.println(d.getMonths());
        System.out.println();


        tdM.addItemsFromFile("sss");
        System.out.println(tdM);
*/


        String title = "go to Codecool";
        LocalDate deadline = LocalDate.of(2017, Month.JUNE, 16);
        tdQ.addItem(title, deadline);

        title = "make coffee";
        deadline = LocalDate.of(2017, Month.JUNE, 14);
        tdQ.addItem(title, deadline);

        title = "code";
        deadline = LocalDate.of(2017, Month.JULY, 24);
        tdQ.addItem(title, deadline);

        tdQ.getItem(1).mark();
       // tdQ.archiveItems();
        System.out.println(tdQ);
    }
}
