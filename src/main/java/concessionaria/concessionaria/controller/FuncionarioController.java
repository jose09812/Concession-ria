package concessionaria.concessionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import concessionaria.concessionaria.entities.Funcionario;
import concessionaria.concessionaria.service.FuncionarioService;

public class FuncionarioController {
     
    @Autowired  
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios(){
    List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();
    if (funcionarios != null) {
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(funcionarios , HttpStatus.NOT_FOUND);
        
    }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.getFuncionarioById(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(funcionario,HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario funcionario ){
        Funcionario funcionarioNovo = funcionarioService.saveFuncionario(funcionario);
        if (funcionarioNovo != null) {
            return new ResponseEntity<>(funcionario , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,@RequestBody Funcionario funcionarioAtualizado){
            Funcionario funcionario = funcionarioService.updateFuncionario(id, funcionarioAtualizado);
            if (funcionario != null) {
                return new ResponseEntity<>(funcionario, HttpStatus.OK);
                
            } else {
                return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND); 
            }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> deleteLogical(@PathVariable Long id){
        Funcionario funcionario = funcionarioService.deleteLogical(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(funcionario, HttpStatus.NOT_FOUND);
        }
    }
}
