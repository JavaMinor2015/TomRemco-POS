
package controller;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the controller package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsValid_QNAME = new QName("http://impl.service.soap.api.fiche.e20150907/", "isValid");
    private final static QName _IsValidResponse_QNAME = new QName("http://impl.service.soap.api.fiche.e20150907/", "isValidResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: controller
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsValid }
     * 
     */
    public IsValid createIsValid() {
        return new IsValid();
    }

    /**
     * Create an instance of {@link IsValidResponse }
     * 
     */
    public IsValidResponse createIsValidResponse() {
        return new IsValidResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.soap.api.fiche.e20150907/", name = "isValid")
    public JAXBElement<IsValid> createIsValid(IsValid value) {
        return new JAXBElement<IsValid>(_IsValid_QNAME, IsValid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsValidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.soap.api.fiche.e20150907/", name = "isValidResponse")
    public JAXBElement<IsValidResponse> createIsValidResponse(IsValidResponse value) {
        return new JAXBElement<IsValidResponse>(_IsValidResponse_QNAME, IsValidResponse.class, null, value);
    }

}
