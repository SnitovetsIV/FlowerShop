package by.snitavets.flowershop.entity.flower;

import by.snitavets.flowershop.entity.Flower;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
//живые цветы
public class NaturalFlower extends Flower {

    private static final Logger LOG = Logger.getLogger(NaturalFlower.class);
    private static final long serialVersionUID = 8722413815083004258L;
    private int lifetime; //in days

    public NaturalFlower(int id) {
        super(id);
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        if (lifetime > 0) {
            this.lifetime = lifetime;
        } else {
            LOG.warn("Lifetime must be greater than zero. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.lifetime;
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
        final NaturalFlower other = (NaturalFlower) obj;
        if (!super.equals(other)) {
            return false;
        }
        return this.lifetime == other.lifetime;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "lifetime=" + lifetime + '}';
    }

}
