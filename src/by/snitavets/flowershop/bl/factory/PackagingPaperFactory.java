package by.snitavets.flowershop.bl.factory;

import by.snitavets.flowershop.bl.FlowerPackagingFactory;
import by.snitavets.flowershop.entity.FlowerPackaging;
import by.snitavets.flowershop.entity.pack.PackagingPaper;
import by.snitavets.flowershop.exception.TOException;
import by.snitavets.flowershop.to.FlowerPackagingTO;
import by.snitavets.flowershop.to.PackagingPaperTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Илья
 */
public class PackagingPaperFactory extends FlowerPackagingFactory {

    private static PackagingPaperFactory instance;
    private static final Logger LOG = Logger.getLogger(PackagingPaperFactory.class);

    private PackagingPaperFactory() {
    }

    public static PackagingPaperFactory getInstance() {
        if (null == instance) {
            instance = new PackagingPaperFactory();
        }
        return instance;
    }

    @Override
    public FlowerPackaging createFlowerPackaging(FlowerPackagingTO to) throws TOException {
        if ((null == to) || !(to instanceof PackagingPaperTO)) {
            LOG.error("Illegal TO.");
            throw new TOException("Illegal TO.");
        }
        PackagingPaperTO packTO = (PackagingPaperTO) to;
        PackagingPaper flowerPackaging = new PackagingPaper(to.id);
        flowerPackaging.setMaterial(packTO.material);
        flowerPackaging.setLength(packTO.length);
        return flowerPackaging;
    }

}
