package kaylin.main;

import kaylin.data.Menu;
import kaylin.data.PhoneList;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PhoneManagement {
    public static void main(String[] args) {
        ArrayList<String> options = createMenu();
        PhoneList phones = new PhoneList();

        int choice;
        boolean flag = true;
        Menu<String> menu = new Menu<>();

        do {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            choice = menu.getChoice(options);
            switch (choice) {
                case 1:
                    phones.addPhone();
                    phones.printAll();
                    break;
                case 2:
                    if (phones.removePhone())
                        phones.printAll();
                    break;
                case 3:
                    phones.sortPhoneBySales();
                    break;
                default:
                    System.out.println("Goodbye");
                    flag = false;
            }
        } while (flag);
    }

    public static ArrayList<String> createMenu() {
        ArrayList<String> menu = new ArrayList<>();

        menu.add("Add new phone then print out the phone list.");
        menu.add("Remove phone by phone ID then print out the phone list.");
        menu.add("Print out the phone list in ascending sales.");
        menu.add("Exit.");

        return menu;
    }
}
