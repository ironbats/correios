package br.com.correios.http;

import br.com.correios.domain.AddressCorreios;
import br.com.correios.domain.CorreiosResult;
import br.com.correios.service.CorreiosService;
import br.com.correios.service.DefaultCorreiosResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CorreiosController {

    @Autowired
    private CorreiosService correiosService;

    @Autowired
    private DefaultCorreiosResultService defaultCorreiosService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public CorreiosResult getCorreiosResult(@PathVariable String cep) {
        return correiosService.getCorreiosResultByCep(cep.replace("-",""));
    }

    @GetMapping("/cep2/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public AddressCorreios getCorreiosResult2(@PathVariable String cep) {
        return defaultCorreiosService.getCorreiosFromCep(cep.replace("-",""));
    }

}
