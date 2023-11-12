package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
