package br.com.correios.service;

import br.com.correios.domain.CorreiosResult;
import br.com.correios.utils.ConverterCorreiosResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

@Service
@Slf4j
public class CorreiosService {

    public CorreiosResult getCorreiosResultByCep(final String cep) {

        AtendeClienteService service = new AtendeClienteService();
        EnderecoERP enderecoERP = null;

        try {
            AtendeCliente port = service.getAtendeClientePort();
            enderecoERP = port.consultaCEP(cep);

        } catch (SQLException_Exception | SigepClienteException cause) {
            log.warn("problem with correios wsl " + cause);
        }
        return ConverterCorreiosResult.converter(enderecoERP);
    }

}
