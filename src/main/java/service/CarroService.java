package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Carro;
import repository.CarroRepository;

public class CarroService {

    @Autowired
    public CarroRepository carroRepository;

    public List<Carro> getAllCarros(){
        List<Carro> carros = carroRepository.findAll();
        return carros;

    }
    public Carro getCarroByChassi(Long id , String chassi){

        Carro carro = new Carro();
        carro.getCarroByChassi(getAllCarros(), chassi);
        return carro;

    }
    public Carro saveCarro(Long id, Carro carro ){
        Carro carroNovo = carroRepository.save(carro);
        Carro carroVerificado = getCarroByChassi(id, carroNovo.getNumeroChassi());
        return carroVerificado;

    }
    public Carro updateCarro(Long id , Carro carroAtualizado, String chassi){
        Carro carroAntigo = getCarroByChassi(id, chassi);
        return carroAntigo;
//concertar esse metodo

    }
    public Carro deleteLogicalCarro(Long id , String chassi ){
        Carro carro = getCarroByChassi(id, chassi);
        carro.setCarroDisponivel(false);
        return carro;


    }
}
