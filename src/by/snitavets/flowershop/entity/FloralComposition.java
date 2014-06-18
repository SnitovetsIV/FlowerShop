package by.snitavets.flowershop.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class FloralComposition {

    private static final Logger LOG = Logger.getLogger(FloralComposition.class);

    private List<Flower> allFlowers;
    private FlowerPackaging pack;

    public FloralComposition() {
        allFlowers = new ArrayList<>();
    }

    public FlowerPackaging getFlowerPackaging() {
        return pack;
    }

    public void setFlowerPackaging(FlowerPackaging pack) {
        if (pack != null) {
            this.pack = pack;
        } else {
            LOG.warn("Flower packaging can not be null. Value has not been assigned.");
        }
    }

    public void addFlower(Flower flower) {
        if (flower != null) {
            allFlowers.add(flower);
        } else {
            LOG.warn("Added flower can not be null. Flower has not been added.");
        }
    }

    public void setAllFlowers(List<Flower> newList) {
        if (newList != null) {
            this.allFlowers = newList;
        } else {
            LOG.warn("New list of flowers can not be null. Value has not been assigned.");
        }
    }

    public void sort(Comparator<? super Flower> comparator) {
        if (comparator != null) {
            allFlowers.sort(comparator);
        } else {
            LOG.warn("Comparator can not be null. Floral composition don't sort.");
        }
    }

    public Iterator<Flower> getAllFlowers() {
        return allFlowers.iterator();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.allFlowers);
        hash = 53 * hash + Objects.hashCode(this.pack);
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
        final FloralComposition other = (FloralComposition) obj;
        if (!Objects.equals(this.allFlowers, other.allFlowers)) {
            return false;
        }
        return Objects.equals(this.pack, other.pack);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + "allFlowers=" + allFlowers + ", pack=" + pack + '}';
    }

}
