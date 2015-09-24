package e20150907.fiche.domain.concrete.criteria;

import e20150907.fiche.domain.abs.Criteria;
import e20150907.fiche.domain.abs.ScanItem;

import java.util.List;

/**
 * Created by alex on 9/16/15.
 */
public class AndCriteria extends Criteria {
    private Criteria[] criteria;

    public AndCriteria(Criteria... criteria){
        this.criteria = criteria;
    }

    @Override
    public List<ScanItem> meetCriteria(List<ScanItem> items) {
        List<ScanItem> meetCriteria = items;
        for (Criteria crit : criteria) {
            meetCriteria = crit.meetCriteria(meetCriteria);
        }
        return meetCriteria;
    }
}
