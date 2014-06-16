package by.snitavets.flowershop.entity;

import java.util.Comparator;

/**
 *
 * @author Илья
 */
public class FlowerComparator implements Comparator<Flower> {

    @Override
    public int compare(Flower t, Flower t1) {
        return t.compareTo(t1);
    }

}
