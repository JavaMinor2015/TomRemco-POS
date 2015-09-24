package e20150907.fiche.repository;

import e20150907.fiche.domain.concrete.transactions.Sale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Tom on 23-9-2015.
 */
public class SaleRepository {
    private static Logger logger = LogManager.getLogger(SaleRepository.class.getName());
    private List<Sale> scanItems;
    private static SaleRepository instance;

    private SaleRepository(){

    }

    public static SaleRepository createInstance(){
        if(instance == null)
            synchronized (SaleRepository.class) {
                if (instance == null)
                    instance = new SaleRepository();
            }
        return instance;
    }
}
