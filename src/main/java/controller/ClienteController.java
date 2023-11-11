package controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import entities.Cliente;
import service.ClienteService;

@Controller
public class ClienteController {
    
    @Autowired  
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
    List<Cliente> clientes = clienteService.getAllClientes();
    if (clientes != null) {
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(clientes , HttpStatus.NOT_FOUND);
        
    }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(cliente,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(Cliente cliente ){
        Cliente clienteNovo = clienteService.saveCliente(cliente);
        if (clienteNovo != null) {
            return new ResponseEntity<>(cliente , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, Cliente clienteAtualizado){
            Cliente cliente = clienteService.updateCliente(id, clienteAtualizado);
            if (cliente != null) {
                return new ResponseEntity<>(cliente, HttpStatus.OK);
                
            } else {
                return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); 
            }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteLogical(@PathVariable Long id){
        Cliente cliente = clienteService.deleteLogical(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }

    
}
