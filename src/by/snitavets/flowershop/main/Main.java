package by.snitavets.flowershop.main;

import by.snitavets.flowershop.bl.Director;
import by.snitavets.flowershop.bl.Find;
import by.snitavets.flowershop.bl.builder.FloralCompositionBuilder;
import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.Flower;
import by.snitavets.flowershop.entity.FlowerComparator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 *
 * @author Илья
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] argv) {
        Director director = new Director(new FloralCompositionBuilder());
        FloralComposition composition = director.createFloralComposition();
        composition.sort(new FlowerComparator());
        Flower flowerInRange = Find.findByRangeOfStem(composition, 23, 24);
        LOG.info(flowerInRange.toString());
    }

}
