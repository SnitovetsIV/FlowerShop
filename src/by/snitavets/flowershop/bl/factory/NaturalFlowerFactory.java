package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerFactory;
import by.snitavets.flowershop.entity.flower.NaturalFlower;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerTO;
import by.snitavets.flowershop.to.NaturalFlowerTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class NaturalFlowerFactory extends FlowerFactory {

    private static final Logger log = Logger.getLogger(NaturalFlowerFactory.class);

    private static NaturalFlowerFactory instance;

    private NaturalFlowerFactory() {
    }

    public static NaturalFlowerFactory getInstance() {
        if (null == instance) {
            instance = new NaturalFlowerFactory();
        }
        return instance;
    }

    @Override
    public NaturalFlower createFlower(FlowerTO to) throws TOException {
        if ((null == to) || !(to instanceof NaturalFlowerTO)) {
            log.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        NaturalFlowerTO naturalFlowerTO = (NaturalFlowerTO) to;
        NaturalFlower flower = new NaturalFlower();
        flower.setPrice(naturalFlowerTO.price);
        flower.setColor(naturalFlowerTO.color);
        flower.setFreshness(naturalFlowerTO.freshness);
        flower.setStemLength(naturalFlowerTO.stemLength);
        flower.setLifetime(naturalFlowerTO.lifetime);
        return flower;
    }

}
