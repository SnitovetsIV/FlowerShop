package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.entity.FlowerPackaging;
import by.snitavets.flowershop.exception.LogicException;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Counter {

    private static final Logger LOG = Logger.getLogger(Counter.class);

    public static double countTotalPrice(FloralComposition floralComposition)
            throws LogicException {
        if (floralComposition == null) {
            LOG.error("Floral composition can not be null.");
            throw new LogicException("Floral composition can not be null.");
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
