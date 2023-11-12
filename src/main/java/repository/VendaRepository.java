package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long>{
    
}
