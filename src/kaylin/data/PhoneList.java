package kaylin.data;

import kaylin.utils.InputHandler;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneList extends ArrayList<Phone> {
    public PhoneList() {
        super();
    }

    public int searchID(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getPhoneID().equals(code.trim().toUpperCase()))
                return i;
        }
        return -1;
    }

    public void addPhone() {
        String id;
        do {
            id = InputHandler.noDuplicateAndPattern(phoneIdDuplicate, "Enter Phone ID (PHxxx): ", "No duplicate phone ID.", "^PH[0-9]{3}$");
            if (searchID(id) != -1) {
                System.out.println("No duplicate code.");
            }
        } while (searchID(id) != -1);

        Phone phone = new Phone(id);
        phone.setPhoneName(InputHandler.inputNonBlankStr("Enter phone name (no empty): "));
        phone.setDayOfSale(InputHandler.inputDatePattern("Enter day of sale (dd/mm/yyyy): ", "^(0{0,1}[1-9]|[12][0-9]|3[01])/(0{0,1}[1-9]|1[012])/(19|20)\\d\\d$"));
        phone.setSales(InputHandler.getIntegerInRange("Enter price (1<=price<=1000): ", 1, 1000));

        this.add(phone);
        System.out.println("Add successfully.");
    }

    private IDuplicate phoneIdDuplicate = code -> {
        return searchID(code) != -1;
    };

    public boolean removePhone() {
        String id = InputHandler.inputNonBlankStr("Enter phone ID to remove: ");
        int position = searchID(id);

        if (position < 0) {
            System.out.println("Not found.");
            return false;
        } else {
            this.remove(position);
            System.out.println("Remove successfully.");
        }
        return true;
    }

    public void sortPhoneBySales() {
        Collections.sort(this, new SortBySales());
        printAll();
    }

    public void printAll() {
        if (this.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        for (int i = 0; i < this.size(); i++) {
            this.get(i).output();
        }
    }
}
