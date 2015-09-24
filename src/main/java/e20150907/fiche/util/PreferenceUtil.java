package e20150907.fiche.util;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alex on 9/10/15.
 */
@XmlRootElement
public class PreferenceUtil {
    // TODO fix properly

    @Getter
    @XmlElement
    private static final String[] PRICING_CATEGORIES = new String[]{"ECO","MEAL"};

    @Getter
    private static final String CATEGORY_KEY_NAME = "type";
    public static final String BILL_SALE_DESCRIPTION = "========Bill of Sale=======";
}
