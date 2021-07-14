package kaylin.data;

import java.util.Comparator;

public class SortBySales implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getSales() - o2.getSales();
    }
}
