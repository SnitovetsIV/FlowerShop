package by.snitavets.flowershop.logic.builder;

import by.snitavets.flowershop.entity.flower.AbstractFlower;
import by.snitavets.flowershop.entity.flower.CutFlower;
import by.snitavets.flowershop.entity.flower.FreshnessType;
import by.snitavets.flowershop.entity.flower.ReproductionType;
import by.snitavets.flowershop.entity.packaging.PackagingPaper;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Created by Илья on 23.06.2014.
 */
public class CutFloralCompositionBuilder extends AbstractFloralCompositionBuilder {

    @Override
    public void buildFlowers() {
        ArrayList<AbstractFlower> list = new ArrayList<>();
        list.add(new CutFlower(1, 2.3, Color.PINK, FreshnessType.FRESHEST, 10, ReproductionType.LAYERING, 12));
        list.add(new CutFlower(2, 2.3, Color.blue, FreshnessType.NOT_FRESH, 12, ReproductionType.CUTTING, 121));
        list.add(new CutFlower(3, 2.3, Color.magenta, FreshnessType.SECOND_FRESH, 15, ReproductionType.BULB, 13));
        if (getFlowerBouquet() == null) {
            createNewFloralComposition("Best");
        }
        getFlowerBouquet().setAllFlowers(list);
    }

    @Override
    public void buildFlowerPackaging() {
        getFlowerBouquet().setFlowerPackaging(new PackagingPaper(1));
    }

}
