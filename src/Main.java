import com.sun.org.apache.bcel.internal.generic.Select;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        TodoMatrix todoMatrix = new TodoMatrix();
        Main main = new Main();
        Scanner scanner;
        todoMatrix.addItemsFromFile("todo_items_read_test.csv");


        while (isRunning) {
            main.menuMain();
            System.out.print("Select: ");
            scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println(todoMatrix);
                    break;
                }
                case 2: {
                    Scanner createScanner = new Scanner(System.in);
                    String title;
                    int day;
                    int month;
                    boolean isImportant;
                    System.out.print("Task title: ");
                    title = createScanner.nextLine();
                    System.out.print("DeadLine( day month): ");
                    day = createScanner.nextInt();
                    month = createScanner.nextInt();
                    System.out.println("Important(true/false)");
                    isImportant = createScanner.nextBoolean();
                    todoMatrix.addItem(title, LocalDate.of(2019, month, day), isImportant);
                    break;
                }

                case 3: {
                    todoMatrix.archiveItems();
                    break;
                }

                case 4: {
                    boolean isSubmenu = true;
                    String quarter = "";
                    main.quarterMenu();
                    Scanner quarterScanner = new Scanner(System.in);
                    System.out.print("Select: ");
                    quarter = main.choose(quarterScanner.nextInt());
                    System.out.println(quarter);
                    while (isSubmenu) {
                        main.subMenu();
                        System.out.print("\nSelect: ");
                        Scanner submenuScanner = new Scanner(System.in);
                        switch (submenuScanner.nextInt()) {
                            case 1: {
                                System.out.println(todoMatrix.getQuarter(quarter));
                                break;
                            }
                            case 2: {
                                System.out.println(todoMatrix.getQuarter(quarter));
                                System.out.print("Select ID: ");
                                todoMatrix.getQuarter(quarter).removeItem(submenuScanner.nextInt() -1 );
                                break;
                            }

                            case 3: {
                                System.out.println(todoMatrix.getQuarter(quarter));
                                System.out.print("Select ID: ");
                                todoMatrix.getQuarter(quarter).getItem(submenuScanner.nextInt()-1).mark();
                                break;
                            }

                            case 4: {
                                todoMatrix.getQuarter(quarter).archiveItems();
                                break;
                            }
                            case 5:
                                isSubmenu = false;
                                break;
                        }
                    }

                }
                case 5:
                    System.exit(1);

            }


        }
    }

    public void menuMain() {
        System.out.println("1. Show matrix");
        System.out.println("2. Add to matrix");
        System.out.println("3. Archive done task");
        System.out.println("4. Enter to quarter");
        System.out.println("5. Exit");
    }

    public void subMenu() {
        System.out.println("1. Show quarter");
        System.out.println("2. Delete from quarter");
        System.out.println("3. Mark done Task");
        System.out.println("4. Archive quarter");
        System.out.println("5. Back to main menu");

    }

    public void quarterMenu() {
        System.out.println("1. IU - important and urgent");
        System.out.println("2. IN - important and not urgent");
        System.out.println("3. NU - not important and urgent");
        System.out.println("4. NN - not important and not urgent");
    }

    public String choose(int scanner) {
        String quarter = "";
        switch (scanner) {
            case 1:
                quarter = "IU";
                break;
            case 2:
                quarter = "IN";
                break;
            case 3:
                quarter = "NU";
                break;
            case 4:
                quarter = "NN";
        }
        return quarter;
    }
}
