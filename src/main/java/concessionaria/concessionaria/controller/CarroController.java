package concessionaria.concessionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import concessionaria.concessionaria.entities.Carro;
import concessionaria.concessionaria.service.CarroService;

import org.springframework.web.bind.annotation.DeleteMapping;

public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity <List<Carro>> getAllCarros(){
        List <Carro> carros = carroService.getAllCarros();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    } 
    @GetMapping("/id")
    public ResponseEntity <Carro> getCarroByChassi(@PathVariable Long id, String chassi){
        Carro carro = carroService.getCarroByChassi(id, chassi);
        return new ResponseEntity<>(carro,HttpStatus.OK);
    }
    @PostMapping("/id")
    public ResponseEntity <Carro> saveCarro(@PathVariable Long id, Carro carro){
        Carro carroNovo = carroService.saveCarro(id, carro);
        return new ResponseEntity<>(carroNovo,HttpStatus.OK);
    }
    @PutMapping("/id")
    public ResponseEntity <Carro> updateCarro(@PathVariable Long id, Carro carro){
        Carro carroAtualizado = carroService.updateCarro(id, carro, carro.getNumeroChassi());
        return new ResponseEntity<>(carroAtualizado,HttpStatus.OK);
        
    }
    @DeleteMapping("/id")
    public ResponseEntity <Carro> deleteLogicalCarro(@PathVariable Long id , String chassi){
        Carro carro = carroService.deleteLogicalCarro(id, chassi);
        return new ResponseEntity<>(carro, HttpStatus.OK);

    }
    
}
