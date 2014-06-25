package by.snitavets.flowershop.logic.action;

import by.snitavets.flowershop.entity.FloralComposition;
import by.snitavets.flowershop.entity.flower.AbstractFlower;
import by.snitavets.flowershop.exception.LogicException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Илья on 23.06.2014.
 */
public class FloralCompositionSorter {

    private static final Logger LOG = Logger.getLogger(FloralCompositionSorter.class);

    public static FloralComposition sortFlowersByStem(FloralComposition floralComposition) throws LogicException {
        if (floralComposition == null) {
            throw new LogicException("Floral composition can not be null.");
        }
        ArrayList<AbstractFlower> sortedFlowers = new ArrayList<>();
        Iterator<AbstractFlower> iterator = floralComposition.iterator();
        while (iterator.hasNext()) {
            sortedFlowers.add(iterator.next());
        }
        Comparator<AbstractFlower> comparator = (AbstractFlower e1, AbstractFlower e2) -> e1.getStemLength() - e2.getStemLength();
        Collections.sort(sortedFlowers, comparator);
        floralComposition.setAllFlowers(sortedFlowers);
        LOG.info("Floral composition " + ((floralComposition.getName() != null) ? floralComposition.getName() + "" : "") + "sorted");
        return floralComposition;
    }

}
