package by.snitavets.flowershop.entity.flower;

import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class Tulip extends NaturalFlower {

    private static final Logger LOG = Logger.getLogger(Tulip.class);
    private static final long serialVersionUID = 6394694334297346522L;

    private int durationOfFlowering;

    public Tulip(int id) {
        super(id);
    }

    public int getDurationOfFlowering() {
        return durationOfFlowering;
    }

    public void setDurationOfFlowering(int durationOfFlowering) {
        if (durationOfFlowering > 0) {
            this.durationOfFlowering = durationOfFlowering;
        } else {
            LOG.warn("Duration of flowering must be greater than zero. Value has not been assigned.");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.durationOfFlowering;
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
        final Tulip other = (Tulip) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return this.durationOfFlowering == other.durationOfFlowering;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "durationDfFlowering=" + durationOfFlowering + '}';
    }

}
