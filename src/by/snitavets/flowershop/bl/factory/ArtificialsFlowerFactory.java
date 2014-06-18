package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerFactory;
import by.snitavets.flowershop.entity.flower.Artificials;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.ArtificialTO;
import by.snitavets.flowershop.to.FlowerTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class ArtificialsFlowerFactory extends FlowerFactory {

    private static final Logger LOG = Logger.getLogger(ArtificialsFlowerFactory.class);

    private static ArtificialsFlowerFactory instance;

    private ArtificialsFlowerFactory() {
    }

    public static ArtificialsFlowerFactory getInstance() {
        if (null == instance) {
            instance = new ArtificialsFlowerFactory();
        }
        return instance;
    }

    @Override
    public Artificials createFlower(FlowerTO to) throws TOException {
        if ((null == to) || !(to instanceof ArtificialTO)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        ArtificialTO artificialTO = (ArtificialTO) to;
        Artificials flower = new Artificials(to.id);
        flower.setPrice(artificialTO.price);
        flower.setColor(artificialTO.color);
        flower.setFreshness(artificialTO.freshness);
        flower.setStemLength(artificialTO.stemLength);
        flower.setMaterial(artificialTO.material);
        return flower;
    }

}
