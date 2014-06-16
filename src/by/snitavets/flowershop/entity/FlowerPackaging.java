package by.snitavets.flowershop.entity;

import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public abstract class FlowerPackaging {

    private static final Logger log = Logger.getLogger(FlowerPackaging.class);

    private String material;
    private double price;

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material != null) {
            this.material = material;
        } else {
            log.warn("Material can not be null. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.material);
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
        final FlowerPackaging other = (FlowerPackaging) obj;
        return Objects.equals(this.material, other.material);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + "material=" + material + '}';
    }

}
