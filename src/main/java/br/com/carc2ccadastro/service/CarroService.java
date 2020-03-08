package br.com.carc2ccadastro.service;

import br.com.carc2ccadastro.domain.Carro;
import br.com.carc2ccadastro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro getCarroById(Long id){
        return carroRepository.getOne(id);
    }


}
