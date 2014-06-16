package by.snitavets.flowershop.entity.pack;

import by.snitavets.flowershop.entity.FlowerPackaging;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class FlowerBasket extends FlowerPackaging {

    private static final Logger log = Logger.getLogger(FlowerBasket.class);

    private int height;     //sm
    private double diameter;//sm

    public FlowerBasket() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            log.warn("Height of basket must be greater than zero. Value has not been assigned.");
        }
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > 0) {
            this.diameter = diameter;
        } else {
            log.warn("Diameter of basket must be greater than zero. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.height;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.diameter) ^ (Double.doubleToLongBits(this.diameter) >>> 32));
        return hash;
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
        final FlowerBasket other = (FlowerBasket) obj;
        if (!super.equals(obj)) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        return Double.doubleToLongBits(this.diameter) == Double.doubleToLongBits(other.diameter);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "height=" + height + ", diameter=" + diameter + '}';
    }

}
