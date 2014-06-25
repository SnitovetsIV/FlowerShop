package by.snitavets.flowershop.logic.action;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.flower.AbstractFlower;
import by.snitavets.flowershop.entity.packaging.AbstractFlowerPackaging;
import by.snitavets.flowershop.exception.LogicException;
import org.apache.log4j.Logger;

import java.util.Iterator;

/**
 * @author Илья
 */
public class FloralCompositionPriceCounter {

    private static final Logger LOG = Logger.getLogger(FloralCompositionPriceCounter.class);

    public static double countTotalPrice(FloralComposition floralComposition)
            throws LogicException {
        if (floralComposition == null) {
            throw new LogicException("Floral composition can not be null.");
        }
        double result = 0;
        Iterator<AbstractFlower> it = floralComposition.iterator();
        while (it.hasNext()) {
            result += it.next().getPrice();
        }
        AbstractFlowerPackaging pack = floralComposition.getFlowerPackaging();
        if (pack != null) {
            result += pack.getPrice();
        }
        LOG.info("Total price of " + ((floralComposition.getName() != null) ? floralComposition.getName() + "" : "") + " =" + result);
        return result;
    }

}
