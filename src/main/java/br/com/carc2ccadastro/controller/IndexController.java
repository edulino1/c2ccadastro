package br.com.carc2ccadastro.controller;

import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/")
    public String getIndex(Model model, Carro carro){
        return "index";
    }

    @GetMapping("/listar")
    public String getLista(Model model, Carro carro){

        List<Carro> listaCarros = carroService.getAllCars();

        model.addAttribute("listaCarros", listaCarros);

        return "lista-carros";
    }

    @PostMapping("/")
    public String postIndex(Model model, Carro carro, BindingResult bindingResult, RedirectAttributes attributes){

        if(bindingResult.hasErrors()){
            return "Erro ao salvar!";
        }

        carroService.postCarro(carro);

        attributes.addFlashAttribute("success", "Cadastrado com sucesso");

        return "redirect:/";
   }

    @PostMapping("/delete/{id}")
    public String deleteIndex(@PathVariable("id") Long id) {

        Optional<Carro> carroExiste = carroService.getCarroById(id);

        if(carroExiste.isPresent()){

            carroService.deletarCarro(id);

        }

        return "redirect:/listar";

    }

}
