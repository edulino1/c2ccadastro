package br.com.carc2ccadastro.service;

import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCars(){
       return carroRepository.findAll();
    }

    public Optional<Carro> getCarroById(Long id){
        return carroRepository.findById(id);
    }

    public Carro postCarro(Carro carro){
        return carroRepository.save(carro);
    }

    public void deletarCarro(Long id){
        carroRepository.deleteById(id);
    }
}
