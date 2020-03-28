package br.com.carc2ccadastro.service;

import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCars(){
       return carroRepository.findAll();
    }

    public Carro postCarro(Carro carro){
        return carroRepository.save(carro);
    }
}
