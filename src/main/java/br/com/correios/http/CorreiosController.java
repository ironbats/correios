package br.com.correios.http;

import br.com.correios.domain.CorreiosResult;
import br.com.correios.service.CorreiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CorreiosController {

    @Autowired
    private CorreiosService correiosService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public CorreiosResult getCorreiosResult(@PathVariable String cep) {
        return correiosService.getCorreiosResultByCep(cep.replace("-",""));
    }

}
