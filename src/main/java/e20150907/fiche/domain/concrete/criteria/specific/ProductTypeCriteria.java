package e20150907.fiche.domain.concrete.criteria.specific;

import e20150907.fiche.domain.abs.Criteria;
import e20150907.fiche.domain.abs.ScanItem;
import e20150907.fiche.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 9/16/15.
 */
public class ProductTypeCriteria extends Criteria {

    private final String categoryKeyName = PreferenceUtil.getCATEGORY_KEY_NAME();
    private String type;

    public ProductTypeCriteria(final String type){
        this.type = type;
    }

    @Override
    public List<ScanItem> meetCriteria(final List<ScanItem> items) {
        List<ScanItem> meetCriteria = new ArrayList<ScanItem>();

        for (ScanItem item : items) {

            if(item.hasProperty(categoryKeyName)){
                if(item.getProperty(categoryKeyName).equals(type)){
                    meetCriteria.add(item);
                }
            }
        }

        return meetCriteria;
    }
}
