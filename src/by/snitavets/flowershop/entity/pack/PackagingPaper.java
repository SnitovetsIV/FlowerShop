package by.snitavets.flowershop.entity.pack;

import by.snitavets.flowershop.entity.FlowerPackaging;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class PackagingPaper extends FlowerPackaging {

    private static final Logger log = Logger.getLogger(PackagingPaper.class);

    private int length; //sm

    public PackagingPaper() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.length;
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
        final PackagingPaper other = (PackagingPaper) obj;
        if (!super.equals(obj)) {
            return false;
        }
        return this.length == other.length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            log.warn("Lenght of paper must be greater than zero. Value has not been assigned.");
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + super.toString() + "length=" + length + '}';
    }

}
