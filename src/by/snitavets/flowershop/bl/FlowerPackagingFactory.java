package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FlowerPackaging;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerPackagingTO;

/**
 *
 * @author Илья
 */
public abstract class FlowerPackagingFactory {

    public abstract FlowerPackaging createFlowerPackaging(FlowerPackagingTO to) throws TOException;
}
