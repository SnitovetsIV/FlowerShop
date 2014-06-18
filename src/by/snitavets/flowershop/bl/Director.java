package by.snitavets.flowershop.bl;

import by.snitavets.flowershop.bl.builder.FloralCompositionBuilder;
import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.FreshnessEnum;
import by.snitavets.flowershop.entity.flower.RoseType;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerBasketTO;
import by.snitavets.flowershop.to.FlowerEnum;
import by.snitavets.flowershop.to.FlowerPackagingEnum;
import by.snitavets.flowershop.to.RoseTO;
import by.snitavets.flowershop.to.TulipTO;
import java.awt.Color;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Director {

    private static final Logger LOG = Logger.getLogger(Director.class);

    private IFloralCompositionBuilder builder;

    public Director() {
        this.builder = new FloralCompositionBuilder();
    }

    public Director(IFloralCompositionBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(IFloralCompositionBuilder builder) {
        this.builder = builder;
    }

    public IFloralCompositionBuilder getBuilder() {
        return this.builder;
    }

    public FloralComposition createFloralComposition() {
        builder.createNewFloralComposition();
        try {
            RoseTO roseTO = new RoseTO();
            roseTO.color = Color.RED;
            roseTO.flowerType = FlowerEnum.ROSE;
            roseTO.freshness = FreshnessEnum.FRESHEST;
            roseTO.price = 10;
            roseTO.stemLength = 1;
            roseTO.lifetime = 10;
            roseTO.type = RoseType.GARDEN;
            builder.addFlower(roseTO);
            roseTO.lifetime = 12;
            roseTO.stemLength = 23;
            roseTO.type = RoseType.PARK;
            roseTO.freshness = FreshnessEnum.SECOND_FRESH;
            builder.addFlower(roseTO);
            TulipTO tulipTO = new TulipTO();
            tulipTO.color = Color.GREEN;
            tulipTO.lifetime = 10;
            tulipTO.durationOfFlowering = 10;
            tulipTO.freshness = FreshnessEnum.FIRST_FRESH;
            tulipTO.flowerType = FlowerEnum.TULIP;
            tulipTO.price = 1.2;
            tulipTO.stemLength = 3;
            builder.addFlower(tulipTO);
            tulipTO.stemLength = 24;
            tulipTO.freshness = FreshnessEnum.FRESHEST;
            tulipTO.durationOfFlowering = 2;
            builder.addFlower(tulipTO);
            FlowerBasketTO basketTO = new FlowerBasketTO();
            basketTO.diameter = 2;
            basketTO.height = 3;
            basketTO.material = "wood";
            basketTO.packType = FlowerPackagingEnum.FLOWER_BASKET;
            basketTO.price = 100.3;
            builder.setFlowerPackaging(basketTO);
        } catch (TOException ex) {
            LOG.error(ex.getMessage());
        }
        return builder.getFloralComposition();
    }
}
