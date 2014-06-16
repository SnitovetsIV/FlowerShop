package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerPackagingTO;
import by.snitavets.flowershop.to.FlowerTO;

/**
 *
 * @author Илья
 */
public interface IFloralCompositionBuilder {

    public FloralComposition getFloralComposition();

    public void createNewFloralComposition();

    public void addFlower(FlowerTO to) throws TOException;

    public void setFlowerPackaging(FlowerPackagingTO to) throws TOException;
}
