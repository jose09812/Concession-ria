package concessionaria.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import concessionaria.concessionaria.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
