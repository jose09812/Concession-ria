package concessionaria.concessionaria.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import concessionaria.concessionaria.entities.Cliente;
import concessionaria.concessionaria.service.ClienteService;

@Controller
public class ClienteController {
    
    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired  
    private ClienteService clienteService;

    @GetMapping("/GetCliente")
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
    @PostMapping("/saveCliente")
    public ResponseEntity<Cliente> saveCliente(Cliente cliente) {
        logger.info("Received request to save client: {}", cliente);
    
        try {
            // Adicione logs para rastrear o fluxo do método
            logger.info("Attempting to save client...");
    
            Cliente clienteNovo = clienteService.saveCliente(cliente);
    
            if (clienteNovo != null) {
                logger.info("Client saved successfully: {}", clienteNovo);
                return new ResponseEntity<>(clienteNovo, HttpStatus.OK);
            } else {
                logger.error("Failed to save client.");
                return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("An error occurred while saving the client.", e);
            return new ResponseEntity<>(cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/Atualização/{id}")
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
