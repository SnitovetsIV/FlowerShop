package by.snitavets.flowershop.logic.builder;

import by.snitavets.flowershop.entity.FloralComposition;
import org.apache.log4j.Logger;

/**
 * @author Илья
 */
public class Director {

    private static final Logger LOG = Logger.getLogger(Director.class);

    private AbstractFloralCompositionBuilder builder;

    public Director() {
        this.builder = new CutFloralCompositionBuilder();
    }

    public Director(AbstractFloralCompositionBuilder builder) {
        this.builder = builder;
    }

    public AbstractFloralCompositionBuilder getBuilder() {
        return this.builder;
    }

    public void setBuilder(AbstractFloralCompositionBuilder builder) {
        if (builder != null) {
            this.builder = builder;
        } else {
            LOG.warn("Builder can not be null. Value has not been assigned.");
        }
    }

    public FloralComposition createFloralComposition() {
        builder.createNewFloralComposition();
        builder.buildFlowers();
        builder.buildFlowerPackaging();
        return builder.getFlowerBouquet();
    }
}
