package by.snitavets.flowershop.entity;

import java.awt.Color;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public abstract class Flower implements Comparable<Flower> {

    private static final Logger log = Logger.getLogger(Flower.class);

    private double price;
    private Color color;
    private FreshnessEnum freshness;
    private int stemLength; //in sm

    public Flower() {

    }

    public FreshnessEnum getFreshness() {
        return freshness;
    }

    public void setFreshness(FreshnessEnum freshness) {
        if (freshness != null) {
            this.freshness = freshness;
        } else {
            log.warn("Freshness can not be null. Value has not been assigned.");
        }
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        if (stemLength > 0) {
            this.stemLength = stemLength;
        } else {
            log.warn("Stem length must be greater than zero. Value has not been assigned.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            log.warn("Price must be greater than zero. Value has not been assigned.");
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color != null) {
            this.color = color;
        } else {
            log.warn("Color can not be null. Value has not been assigned.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flower other = (Flower) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return Objects.equals(this.color, other.color);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.color);
        hash = 29 * hash + Objects.hashCode(this.freshness);
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + "price=" + price + ", color=" + color
                + ", freshness=" + freshness + ", stemLength=" + stemLength + '}';
    }

    @Override
    public int compareTo(Flower t) {

        return this.freshness.compareTo(t.freshness);
    }

}
