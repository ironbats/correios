package br.com.correios.utils;

import br.com.correios.domain.CorreiosResult;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

public class ConverterCorreiosResult {


    public static CorreiosResult converter(EnderecoERP erp) {
        return CorreiosResult.builder().
                address(erp.getEnd()).
                cep(erp.getCep()).
                neighborhood(erp.getBairro()).
                city(erp.getCidade()).
                UF(erp.getUf()).complement(erp.getComplemento2()).build();
    }
}
