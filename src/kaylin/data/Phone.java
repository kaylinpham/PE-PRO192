package kaylin.data;

import kaylin.utils.InputHandler;

public class Phone {
    private String phoneID;
    private String phoneName;
    private String dayOfSale;
    private int sales;

    public Phone() {
    }

    public Phone(String phoneID) {
        setPhoneID(phoneID);
    }

    public Phone(String phoneID, String phoneName, String dayOfSale, int sales) {
        setPhoneID(phoneID);
        this.phoneName = phoneName;
        setDayOfSale(dayOfSale);
        setSales(sales);
    }

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        if (!phoneID.toUpperCase().matches("^PH[0-9]{3}$"))
            throw new IllegalArgumentException("Invalid Phone ID (PHxxx).");
        this.phoneID = phoneID.toUpperCase().trim();
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getDayOfSale() {
        return dayOfSale;
    }

    public void setDayOfSale(String dayOfSale) {
        if (!dayOfSale.matches("^(0{0,1}[1-9]|[12][0-9]|3[01])/(0{0,1}[1-9]|1[012])/(19|20)\\d\\d$") && !InputHandler.isValidDate(dayOfSale))
            throw new IllegalArgumentException("Invalid date (dd/mm/yyyy).");
        this.dayOfSale = dayOfSale;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        if (sales < 1 || sales > 1000)
            throw new IllegalArgumentException("Sales in range 1 to 1000.");
        this.sales = sales;
    }

    public void output() {
        System.out.printf("|%5s|%-10s|%10s|%4d|\n", phoneID, phoneName, dayOfSale, sales);
    }
}


