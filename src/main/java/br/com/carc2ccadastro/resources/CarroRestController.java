package br.com.carc2ccadastro.resources;


import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/app/api")
public class CarroRestController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> getAllCarros(){

        List<Carro> carro = carroService.findAllCars();

        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @PostMapping("/carro/salvar")
    public ResponseEntity<Carro> postCarro(Carro carro){

        carroService.postCarro(carro);

        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }


    @DeleteMapping("/carro/excluir/{id}")
    public ResponseEntity<Carro> deletarCarro(@PathVariable("id") Long id, Carro carro){

        Optional<Carro> carroExiste = carroService.getCarroById(id);

        if(carroExiste.isPresent()){

            carroService.deletarCarro(id);

            return new ResponseEntity<>(carro, HttpStatus.OK);

        }else{

            return new ResponseEntity<>(carro, HttpStatus.NO_CONTENT);

        }
    }
}

