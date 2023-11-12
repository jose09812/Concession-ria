package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import entities.Venda;

import service.VendaService;

public class VendasController {
    @Autowired  
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas(){
    List<Venda> vendas = vendaService.getAllVendas();
    if (vendas != null) {
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(vendas , HttpStatus.NOT_FOUND);
        
    }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable Long id){
        Venda venda = vendaService.getVendaById(id);
        if (venda != null) {
            return new ResponseEntity<>(venda, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(venda,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Venda> saveVenda(Venda venda ){
        Venda vendaNovo = vendaService.saveVenda(venda);
        if (vendaNovo != null) {
            return new ResponseEntity<>(venda , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(venda, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Venda> updateVenda(@PathVariable Long id, Venda vendaAtualizado){
            Venda venda = vendaService.updateVenda(id, vendaAtualizado);
            if (venda != null) {
                return new ResponseEntity<>(venda, HttpStatus.OK);
                
            } else {
                return new ResponseEntity<>(venda, HttpStatus.NOT_FOUND); 
            }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Venda> deleteLogical(@PathVariable Long id){
        Venda venda = vendaService.deleteLogical(id);
        if (venda != null) {
            return new ResponseEntity<>(venda,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(venda, HttpStatus.NOT_FOUND);
        }
    }
}
