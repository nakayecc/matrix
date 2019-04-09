import java.time.LocalDate;

public class Main {
    public static void main( String[] args){
        LocalDate ld;
        int month = 12;
        int day = 3;

        ld = LocalDate.of(2018,month,day);

        Object test ;

        TodoItem td = new TodoItem("kupic mleko",ld);
        td.mark();


        TodoQuarter tdQ = new TodoQuarter();

        System.out.println(tdQ);
        ld = LocalDate.of(2018,12,3);
        tdQ.addItem("kupic chleb",ld);
        ld = LocalDate.of(2018,12,2);
        td.mark();
        tdQ.addItem("kupic mleko",ld);
        ld = LocalDate.of(2018,12,1);
        tdQ.addItem("kupic koc",ld);
        System.out.println(tdQ);
        tdQ.removeItem(1);
        System.out.println(tdQ);
        //tdQ.archiveItems();
        System.out.println("================");
        System.out.println(tdQ);




    }
}
