package br.com.carc2ccadastro.service;

import br.com.carc2ccadastro.dao.CarroDAO;
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
    
    @Autowired
    private CarroDAO carroDAO;

    public List<Carro> findListCarByLogin(Long usuarioId){
       return carroDAO.findCarroByUsuarioId(usuarioId);
    }
    
    public List<Carro> findAllCars(){
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
    
    public List<Carro> findCarByUsuarioAluguelId(Long usuarioAluguelId){
        return carroDAO.findCarroByUsuarioAluguelId(usuarioAluguelId);
    };
}
