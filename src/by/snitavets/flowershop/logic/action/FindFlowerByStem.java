package by.snitavets.flowershop.logic.action;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.flower.AbstractFlower;
import by.snitavets.flowershop.exception.LogicException;
import org.apache.log4j.Logger;

import java.util.Iterator;

/**
 * @author Илья
 */
public class FindFlowerByStem {

    private static final Logger LOG = Logger.getLogger(FindFlowerByStem.class);

    public static AbstractFlower findByRangeOfStem(FloralComposition floralComposition, int lowerLimit, int upperLimit)
            throws LogicException {
        if (lowerLimit < 0 || upperLimit < 0 || upperLimit < lowerLimit) {
            LOG.error("Illegal argument. Illegal range.");
            throw new LogicException("Illegal range.");
        }
        if (floralComposition == null) {
            LOG.error("Illegal argument. Floral composition can not be null");
            throw new LogicException("Illegal argument. Floral composition can not be null");
        }
        AbstractFlower result = null;
        Iterator<AbstractFlower> it = floralComposition.iterator();
        while (it.hasNext()) {
            AbstractFlower f = it.next();
            if (f.getStemLength() >= lowerLimit && f.getStemLength() <= upperLimit) {
                result = f;
                LOG.info("Found by stem [" + lowerLimit + "," + upperLimit + "]" + result.toString());
                break;
            }
            LOG.info("Not found by stem in [" + lowerLimit + "," + upperLimit + "]");
        }
        return result;
    }
}
