package concessionaria.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import concessionaria.concessionaria.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
