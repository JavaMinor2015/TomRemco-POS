
package controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentItem")
public abstract class PaymentItem {
    private double amount;
    private String type;

    /**
     * Constructor.
     *
     * @param type   the type of products this payment counts for
     * @param amount the amount covered by this item, -1 for infinite.
     */
    public PaymentItem(final String type, final double amount) {
        this.amount = amount;
        this.type = type;
    }

    public abstract double remainder(final double price);

    public boolean hasType() {
        if (type == null || "".equals(type)) {
            return false;
        }
        return true;
    }

    public abstract boolean isValid(double price);

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
