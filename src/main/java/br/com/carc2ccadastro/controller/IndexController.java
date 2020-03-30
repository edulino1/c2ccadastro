package br.com.carc2ccadastro.controller;


import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }


    @PostMapping("/salvar")
    public String postIndex(BindingResult bindingResult, Carro carro){

        if(bindingResult.hasErrors()){
            return "Tem coisa errada ai irmão";
        }

        carroService.postCarro(carro);

        return getIndex();
   }

}
