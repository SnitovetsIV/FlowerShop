package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import java.util.Iterator;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Find {

    private static final Logger log = Logger.getLogger(Find.class);

    public static Flower findByRangeOfStem(FloralComposition floralComposition, int lowerLimit, int upperLimit)
            throws IllegalArgumentException {
        if (lowerLimit < 0 || upperLimit < 0 || upperLimit < lowerLimit) {
            log.error("Illegal argument. Illegal range.");
            throw new IllegalArgumentException("Illegal range.");
        }
        if (floralComposition == null) {
            log.error("Floral composition can not be null");
            throw new IllegalArgumentException("Floral composition can not be null");
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
