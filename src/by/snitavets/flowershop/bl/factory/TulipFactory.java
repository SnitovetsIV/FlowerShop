package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerFactory;
import by.snitavets.flowershop.entity.flower.Tulip;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerTO;
import by.snitavets.flowershop.to.TulipTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class TulipFactory extends FlowerFactory {

    private static final Logger LOG = Logger.getLogger(TulipFactory.class);

    private static TulipFactory instance;

    private TulipFactory() {
    }

    public static TulipFactory getInstance() {
        if (null == instance) {
            instance = new TulipFactory();
        }
        return instance;
    }

    @Override
    public Tulip createFlower(FlowerTO to) throws TOException {
        if ((null == to) || !(to instanceof TulipTO)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        TulipTO tulipTO = (TulipTO) to;
        Tulip tulip = new Tulip(to.id);
        tulip.setPrice(tulipTO.price);
        tulip.setColor(tulipTO.color);
        tulip.setFreshness(tulipTO.freshness);
        tulip.setStemLength(tulipTO.stemLength);
        tulip.setLifetime(tulipTO.lifetime);
        tulip.setDurationOfFlowering(tulipTO.durationOfFlowering);
        return tulip;
    }

}
