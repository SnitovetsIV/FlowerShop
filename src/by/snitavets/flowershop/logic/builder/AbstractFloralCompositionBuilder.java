package by.snitavets.flowershop.logic.builder;

import by.snitavets.flowershop.entity.FloralComposition;

/**
 * Created by Илья on 23.06.2014.
 */
public abstract class AbstractFloralCompositionBuilder {

    private FloralComposition bouquet = new FloralComposition("Best");

    public void createNewFloralComposition() {
        bouquet = new FloralComposition();
    }

    public void createNewFloralComposition(String name) {
        bouquet = new FloralComposition(name);
    }

    public FloralComposition getFlowerBouquet() {
        return bouquet;
    }

    public abstract void buildFlowers();

    public abstract void buildFlowerPackaging();

}
