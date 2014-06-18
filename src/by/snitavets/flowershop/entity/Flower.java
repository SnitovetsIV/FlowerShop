package by.snitavets.flowershop.entity;

import java.awt.Color;
import java.io.Serializable;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public abstract class Flower implements Serializable {

    private static final Logger LOG = Logger.getLogger(Flower.class);
    private static final long serialVersionUID = -5596271192615993599L;

    private final int id;
    private double price;
    private Color color;
    private FreshnessEnum freshness = FreshnessEnum.NOT_FRESH;
    private int stemLength; //in sm

    public Flower(int id) {
        this.id = id;
    }

    public FreshnessEnum getFreshness() {
        return freshness;
    }

    public void setFreshness(FreshnessEnum freshness) {
        if (freshness != null) {
            this.freshness = freshness;
        } else {
            LOG.warn("Freshness can not be null. Value has not been assigned.");
        }
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        if (stemLength > 0) {
            this.stemLength = stemLength;
        } else {
            LOG.warn("Stem length must be greater than zero. Value has not been assigned.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            LOG.warn("Price must be greater than zero. Value has not been assigned.");
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (color != null) {
            this.color = color;
        } else {
            LOG.warn("Color can not be null. Value has not been assigned.");
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.color);
        hash = 29 * hash + Objects.hashCode(this.freshness);
        hash = 29 * hash + this.stemLength;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flower other = (Flower) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (this.freshness != other.freshness) {
            return false;
        }
        return this.stemLength == other.stemLength;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + "id=" + id + ", price=" + price
                + ", color=" + color + ", freshness=" + freshness + ", stemLength=" + stemLength + '}';
    }

}
