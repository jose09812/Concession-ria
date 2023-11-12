package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioService {
     @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> getAllFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
        
    }

    public Funcionario getFuncionarioById(Long id ){
        Funcionario Funcionario = funcionarioRepository.findById(id).orElse(null);

        return Funcionario;

    }
    public Funcionario saveFuncionario(Funcionario funcionario ){
        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return novoFuncionario;
    }
    public Funcionario updateFuncionario(Long id, Funcionario funcionarioAtualizado ){
        Funcionario funcionarioExistente = funcionarioRepository.findById(id).orElse(null);
        funcionarioExistente.setFuncionario(funcionarioExistente, funcionarioAtualizado);
        funcionarioRepository.save(funcionarioExistente);
        return funcionarioExistente;

    }
    public Funcionario deleteLogical(Long id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);
        funcionario.setAtivo(false);
        return funcionario;

    }
}
