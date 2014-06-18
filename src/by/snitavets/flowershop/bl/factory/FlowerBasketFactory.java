package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerPackagingFactory;
import by.snitavets.flowershop.entity.FlowerPackaging;
import by.snitavets.flowershop.entity.pack.FlowerBasket;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerBasketTO;
import by.snitavets.flowershop.to.FlowerPackagingTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class FlowerBasketFactory extends FlowerPackagingFactory {

    private static final Logger LOG = Logger.getLogger(FlowerBasketFactory.class);

    private static FlowerBasketFactory instance;

    private FlowerBasketFactory() {
    }

    public static FlowerBasketFactory getInstance() {
        if (null == instance) {
            instance = new FlowerBasketFactory();
        }
        return instance;
    }

    @Override
    public FlowerPackaging createFlowerPackaging(FlowerPackagingTO to) throws TOException {
        if ((null == to) || !(to instanceof FlowerBasketTO)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        FlowerBasketTO ato = (FlowerBasketTO) to;
        FlowerBasket flowerPackaging = new FlowerBasket(to.id);
        flowerPackaging.setDiameter(ato.diameter);
        flowerPackaging.setHeight(ato.height);
        flowerPackaging.setMaterial(ato.material);
        return flowerPackaging;
    }

}
