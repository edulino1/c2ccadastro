package br.com.carc2ccadastro.resources;


import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("app/api")
public class CarroRestController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carro/{id}")
    public Carro getCarroByUuid(@PathVariable("id") Long id){

         return carroService.getCarroById(id);
    }


}
