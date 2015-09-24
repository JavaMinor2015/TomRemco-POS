package e20150907.fiche.repository;

import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.logic.ProductFactory;
import e20150907.fiche.util.Populator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by alex on 9/9/15.
 */
public class ScanItemRepository {
    private static Logger logger = LogManager.getLogger(ScanItemRepository.class.getName());
    private List<ScanItem> scanItems;
    private static ScanItemRepository instance;

    private ScanItemRepository(){
        // TODO replace when database has been implemented
        Populator populator = ProductFactory.getPopulator();
        scanItems = populator.getAllScanItems();
    }

    public void addScanItem(ScanItem scanItem){
        scanItems.add(scanItem);
    }

    public ScanItem deleteScanItemById(UUID id){
        ScanItem scanItem = getItemById(id);
        scanItems.remove(scanItem);
        return scanItem;
    }

    public ScanItem deleteScanItemByCode(String code){
        ScanItem scanItem = getItemByCode(code);
        scanItems.remove(scanItem);
        return scanItem;
    }

    public List<ScanItem> getProducts(){
        return scanItems;
    }

    public ScanItem getItemById(final UUID id){
        for (ScanItem scanItem : scanItems) {
            if(scanItem.getId().equals(id)){
                return scanItem;
            }
        }
        return null;
    }

    public List<ScanItem> getCards(){
        List<ScanItem> found = new ArrayList<>();

        for (ScanItem scanItem : scanItems) {
            if(scanItem.hasCodeType("cardcode")){
                found.add(scanItem);
            }
        }

        // more than one product found
        if(found.size() < 0){
            logger.error("No card was added.");
            found.forEach(logger::error);

            // nothing can be done, return false to inform caller nothing happened
            return null;
        }
        return found;
    }


    public ScanItem getItemByCode(final String code){
        List<ScanItem> found = new ArrayList<>();

        for (ScanItem scanItem : scanItems) {
            if(scanItem.hasCodeValue(code)){
                found.add(scanItem);
            }
        }

        // more than one product found
        if(found.size() > 1){
            logger.error("More than one product matches an id for " + code);
            logger.error("Product was not added.");
            found.forEach(logger::error);

            // nothing can be done, return false to inform caller nothing happened
            return null;
        }

        // less than one product found
        if (found.size() < 1){
            logger.error("Not one product matches an id for " + code);
            // no error messages, no product found, but code might not be meant for this method
            // return false to inform caller nothing happened
            return null;
        }


        return found.get(0);
    }

    public List<ScanItem> getItemByType(final String type){
        List<ScanItem> found = new ArrayList<>();

        for (ScanItem scanItem : scanItems) {
            if(scanItem.isType(type)){
                found.add(scanItem);
            }
        }

        // less than one product found
        if (found.size() < 1){
            logger.error("Not one product matches an id for " + type);
            // no error messages, no product found, but code might not be meant for this method
            // return false to inform caller nothing happened
            return new ArrayList<>();
        }


        return found;
    }

    public static ScanItemRepository createInstance(){
        if(instance == null)
            synchronized (ScanItemRepository.class) {
                if (instance == null)
                    instance = new ScanItemRepository();
            }
        return instance;
    }
}
