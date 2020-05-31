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
    
    @PostMapping("/carro/salvar/status")
    public ResponseEntity<Carro> postCarroStatus(Carro carroNewStatus) {
    
        try {
    
            Optional<Carro> carroOld = carroService.getCarroById(carroNewStatus.getId());
        
            carroOld.get().setStatusCarro(carroNewStatus.getStatusCarro());
            
            carroOld.get().setUsuarioAluguelId(carroNewStatus.getUsuarioAluguelId());
            
            carroService.postCarro(carroOld.get());
        
            return new ResponseEntity<>(carroOld.get(), HttpStatus.CREATED);
        
        } catch (Exception e) {
            return new ResponseEntity<>(carroNewStatus, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @GetMapping("/carro/aluguel/{usuarioAluguelId}")
    public ResponseEntity<List<Carro>> getCarByUsuarioAluguelId(@PathVariable("usuarioAluguelId") Long usuarioAluguelId){
        
        List<Carro> carro = carroService.findCarByUsuarioAluguelId(usuarioAluguelId);
        
        return new ResponseEntity<>(carro, HttpStatus.OK);
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

