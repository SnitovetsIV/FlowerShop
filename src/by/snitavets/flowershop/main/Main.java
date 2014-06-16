package by.snitavets.flowershop.main;

import by.snitavets.flowershop.bl.Find;
import by.snitavets.flowershop.bl.FloralCompositionBuilder;
import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.entity.FlowerComparator;
import by.snitavets.flowershop.entity.FreshnessEnum;
import by.snitavets.flowershop.entity.flower.RoseType;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerBasketTO;
import by.snitavets.flowershop.to.FlowerEnum;
import by.snitavets.flowershop.to.FlowerPackagingEnum;
import by.snitavets.flowershop.to.RoseTO;
import by.snitavets.flowershop.to.TulipTO;
import java.awt.Color;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Илья
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] argv) {
        try {
            FloralCompositionBuilder builder = new FloralCompositionBuilder();
            RoseTO roseTO = new RoseTO();
            roseTO.color = Color.RED;
            roseTO.flowerType = FlowerEnum.ROSE;
            roseTO.freshness = FreshnessEnum.FRESHEST;
            roseTO.price = 10;
            roseTO.stemLength = 1;
            roseTO.lifetime = 10;
            roseTO.type = RoseType.GARDEN;
            builder.createNewFloralComposition();
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
            FloralComposition composition = builder.getFloralComposition();
            composition.sort(new FlowerComparator());
            Flower flowerInRange = Find.findByRangeOfStem(composition, 23, 24);
            if (flowerInRange != null) {
                log.info(flowerInRange.toString());
            }
        } catch (TOException | IllegalArgumentException ex) {
            log.error(ex.getMessage());
        }
    }

}
