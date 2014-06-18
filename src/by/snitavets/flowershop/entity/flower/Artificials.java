package by.snitavets.flowershop.entity.flower;

import by.snitavets.flowershop.entity.Flower;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
//искусственные цветы
public class Artificials extends Flower {

    private static final Logger LOG = Logger.getLogger(Artificials.class);
    private static final long serialVersionUID = -8315084913736400165L;

    private String material;

    public Artificials(int id) {
        super(id);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material != null) {
            this.material = material;
        } else {
            LOG.warn("Material can not be null. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.material);
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
        final Artificials other = (Artificials) obj;
        if (!super.equals(other)) {
            return false;
        }
        return Objects.equals(this.material, other.material);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "material=" + material + '}';
    }

}
