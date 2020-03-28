package br.com.carc2ccadastro.resources;


import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/app/api")
public class CarroRestController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> getAllCarros(){

        List<Carro> carro = carroService.getAllCars();

        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @PostMapping("/carro/salvar")
    public ResponseEntity<Carro> postCarro(Carro carro){

        carroService.postCarro(carro);

        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }
}

