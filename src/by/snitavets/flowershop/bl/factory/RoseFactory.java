package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerFactory;
import by.snitavets.flowershop.entity.flower.Rose;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerTO;
import by.snitavets.flowershop.to.RoseTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class RoseFactory extends FlowerFactory {

    private static final Logger LOG = Logger.getLogger(RoseFactory.class);

    private static RoseFactory instance;

    private RoseFactory() {
    }

    public static RoseFactory getInstance() {
        if (null == instance) {
            instance = new RoseFactory();
        }
        return instance;
    }

    @Override
    public Rose createFlower(FlowerTO to) throws TOException {
        if ((null == to) || !(to instanceof RoseTO)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        RoseTO roseTO = (RoseTO) to;
        Rose rose = new Rose(to.id);
        rose.setPrice(roseTO.price);
        rose.setColor(roseTO.color);
        rose.setFreshness(roseTO.freshness);
        rose.setStemLength(roseTO.stemLength);
        rose.setLifetime(roseTO.lifetime);
        rose.setType(roseTO.type);
        return rose;
    }

}
