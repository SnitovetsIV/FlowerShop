package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.exception.LogicException;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Find {

    private static final Logger LOG = Logger.getLogger(Find.class);

    public static Flower findByRangeOfStem(FloralComposition floralComposition, int lowerLimit, int upperLimit)
            throws LogicException {
        if (lowerLimit < 0 || upperLimit < 0 || upperLimit < lowerLimit) {
            LOG.error("Illegal argument. Illegal range.");
            throw new LogicException("Illegal range.");
        }
        if (floralComposition == null) {
            LOG.error("Floral composition can not be null");
            throw new LogicException("Floral composition can not be null");
        }
        Flower result = null;
        Iterator<Flower> it = floralComposition.getAllFlowers();
        while (it.hasNext()) {
            Flower f = it.next();
            if (f.getStemLength() >= lowerLimit && f.getStemLength() <= upperLimit) {
                result = f;
                break;
            }
        }
        return result;
    }
}
