package br.com.correios.service;

import br.com.correios.domain.AddressCorreios;
import br.com.correios.exception.SigepClienteException;
import br.com.correios.factory.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.sql.SQLException;


@WebService(name = "AtendeCliente", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
@XmlSeeAlso({
        ObjectFactory.class
})
public interface ConsultaCep {

    /**
     *
     * @param cep
     * @return
     *     returns br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP
     * @throws SQLException
     * @throws SigepClienteException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaCEP", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", className = "br.com.correios.domain.ConsultaCEP")
    @ResponseWrapper(localName = "consultaCEPResponse", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", className = "br.com.correios.domain.ConsultaCEPResponse")
    AddressCorreios consultaCEP(
            @WebParam(name = "cep", targetNamespace = "")
                    String cep)
            throws SQLException, SigepClienteException
    ;
}
