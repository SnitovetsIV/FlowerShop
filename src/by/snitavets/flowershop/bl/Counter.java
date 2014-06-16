package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.entity.FlowerPackaging;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Counter {

    private static final Logger log = Logger.getLogger(Counter.class);

    public static double countTotalPrice(FloralComposition floralComposition)
            throws IllegalArgumentException {
        if (floralComposition == null) {
            log.error("Floral composition can not be null.");
            throw new IllegalArgumentException("Floral composition can not be null.");
        }
        double result = 0;
        Iterator<Flower> it = floralComposition.getAllFlowers();
        while (it.hasNext()) {
            result += it.next().getPrice();
        }
        FlowerPackaging pack = floralComposition.getFlowerPackaging();
        if (pack != null) {
            result += pack.getPrice();
        }
        return result;
    }

}
