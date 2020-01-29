package br.com.correios.factory;

import br.com.correios.domain.ConsultaCEP;
import br.com.correios.domain.ConsultaCEPResponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaCEP_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "consultaCEP");
    private final static QName _ConsultaCEPResponse_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "consultaCEPResponse");

    /**
     * Create an instance of {@link ConsultaCEPResponse }
     *
     */
    public ConsultaCEPResponse createConsultaCEPResponse() {
        return new ConsultaCEPResponse();
    }

    /**
     * Create an instance of {@link ConsultaCEP }
     *
     */
    public ConsultaCEP createConsultaCEP() {
        return new ConsultaCEP();
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCEP }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "consultaCEP")
    public JAXBElement<ConsultaCEP> createConsultaCEP(ConsultaCEP value) {
        return new JAXBElement<ConsultaCEP>(_ConsultaCEP_QNAME, ConsultaCEP.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCEPResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "consultaCEPResponse")
    public JAXBElement<ConsultaCEPResponse> createConsultaCEPResponse(ConsultaCEPResponse value) {
        return new JAXBElement<ConsultaCEPResponse>(_ConsultaCEPResponse_QNAME, ConsultaCEPResponse.class, null, value);
    }
}
