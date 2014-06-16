package by.snitavets.flowershop.to;

import by.snitavets.flowershop.entity.FreshnessEnum;
import java.awt.Color;

/**
 *
 * @author Илья
 */
public abstract class FlowerTO {

    public double price;
    public Color color;
    public FreshnessEnum freshness;
    public int stemLength;
    public FlowerEnum flowerType;
}
