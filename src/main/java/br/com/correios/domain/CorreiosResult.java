package br.com.correios.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CorreiosResult {

    private String neighborhood;
    private String cep;
    private String city;
    private String complement;
    private String address;
    private String UF;

}
