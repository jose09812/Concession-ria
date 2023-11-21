package concessionaria.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import concessionaria.concessionaria.entities.Carro;



public interface CarroRepository extends JpaRepository<Carro,Long>{
    
}
