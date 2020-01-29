package br.com.correios.service;

import br.com.correios.domain.AddressCorreios;
import br.com.correios.exception.SigepClienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DefaultCorreiosResultService {

    @Autowired
    DefaultCorreiosService defaultCorreiosService;


    public AddressCorreios getCorreiosFromCep(String cep) {
        AddressCorreios addressCorreios = null;
        ConsultaCep consultaCep = defaultCorreiosService.getPortFromCorreiosWs();
        try {
            addressCorreios = consultaCep.consultaCEP(cep);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SigepClienteException e) {
            e.printStackTrace();
        }
        return addressCorreios;
    }
}
