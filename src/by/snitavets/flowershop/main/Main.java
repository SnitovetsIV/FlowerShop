package by.snitavets.flowershop.main;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.flower.AbstractFlower;
import by.snitavets.flowershop.exception.LogicException;
import by.snitavets.flowershop.logic.action.FindFlowerByStem;
import by.snitavets.flowershop.logic.action.FloralCompositionPriceCounter;
import by.snitavets.flowershop.logic.action.FloralCompositionSorter;
import by.snitavets.flowershop.logic.builder.CutFloralCompositionBuilder;
import by.snitavets.flowershop.logic.builder.Director;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author Илья
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] argv) throws LogicException {
        Director director = new Director(new CutFloralCompositionBuilder());
        FloralComposition floralComposition = director.createFloralComposition();
        double price = FloralCompositionPriceCounter.countTotalPrice(floralComposition);
        FloralCompositionSorter.sortFlowersByStem(floralComposition);
        AbstractFlower flower = FindFlowerByStem.findByRangeOfStem(floralComposition, 1, 30);
    }

}
