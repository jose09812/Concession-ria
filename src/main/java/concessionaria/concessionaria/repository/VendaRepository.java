package concessionaria.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import concessionaria.concessionaria.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long>{
    
}
