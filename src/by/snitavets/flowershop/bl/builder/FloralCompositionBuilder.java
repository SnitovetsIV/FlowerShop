package by.snitavets.flowershop.bl.builder;

import by.snitavets.flowershop.bl.IFloralCompositionBuilder;
import by.snitavets.flowershop.bl.factory.ArtificialsFlowerFactory;
import by.snitavets.flowershop.bl.factory.FlowerBasketFactory;
import by.snitavets.flowershop.bl.factory.NaturalFlowerFactory;
import by.snitavets.flowershop.bl.factory.PackagingPaperFactory;
import by.snitavets.flowershop.bl.factory.RoseFactory;
import by.snitavets.flowershop.bl.factory.TulipFactory;
import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.entity.FlowerPackaging;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerPackagingTO;
import by.snitavets.flowershop.to.FlowerTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class FloralCompositionBuilder implements IFloralCompositionBuilder {

    private static final Logger LOG = Logger.getLogger(FloralCompositionBuilder.class);

    private FloralComposition floralComposition;
    private int nextID = 0;

    @Override
    public FloralComposition getFloralComposition() {
        return floralComposition;
    }

    @Override
    public void createNewFloralComposition() {
        floralComposition = new FloralComposition();
    }

    @Override
    public void addFlower(FlowerTO to) throws TOException {
        if ((null == to) || (to.flowerType == null)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        Flower flower;
        to.id = nextID;
        nextID++;
        switch (to.flowerType) {
            case ARTIFICIALS:
                flower = ArtificialsFlowerFactory.getInstance().createFlower(to);
                break;
            case NATURAL_FLOWER:
                flower = NaturalFlowerFactory.getInstance().createFlower(to);
                break;
            case ROSE:
                flower = RoseFactory.getInstance().createFlower(to);
                break;
            case TULIP:
                flower = TulipFactory.getInstance().createFlower(to);
                break;
            default:
                LOG.error("Illegal flowerType.");
                throw new TOException("Illegal flowerType.");
        }
        if (null == floralComposition) {
            floralComposition = new FloralComposition();
        }
        floralComposition.addFlower(flower);
        LOG.info("Flower added. " + flower.toString());
    }

    @Override
    public void setFlowerPackaging(FlowerPackagingTO to) throws TOException {
        if ((null == to) || (to.packType == null)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        FlowerPackaging flowerPackaging;
        switch (to.packType) {
            case FLOWER_BASKET:
                flowerPackaging = FlowerBasketFactory.getInstance().createFlowerPackaging(to);
                break;
            case PACKAGING_PAPER:
                flowerPackaging = PackagingPaperFactory.getInstance().createFlowerPackaging(to);
                break;
            default:
                LOG.error("Illegal packType.");
                throw new TOException("Illegal packType.");
        }
        if (null == floralComposition) {
            floralComposition = new FloralComposition();
        }
        floralComposition.setFlowerPackaging(flowerPackaging);
        LOG.info("Flower packaging setted. " + flowerPackaging.toString());
    }

}
