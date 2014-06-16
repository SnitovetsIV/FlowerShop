package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerTO;

/**
 *
 * @author Илья
 */
public abstract class FlowerFactory {

    public abstract Flower createFlower(FlowerTO to) throws TOException;
}
