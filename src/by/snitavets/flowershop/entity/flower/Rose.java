package by.snitavets.flowershop.entity.flower;

import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Rose extends NaturalFlower {

    private static final Logger LOG = Logger.getLogger(Rose.class);
    private static final long serialVersionUID = -902940241373274008L;

    private RoseType type;

    public Rose(int id) {
        super(id);
    }

    public RoseType getType() {
        return type;
    }

    public void setType(RoseType type) {
        if (type != null) {
            this.type = type;
        } else {
            LOG.warn("Type of rose can not be null. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.type);
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
        final Rose other = (Rose) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return this.type == other.type;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "type=" + type + '}';
    }

}
