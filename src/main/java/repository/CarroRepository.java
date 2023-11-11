package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entities.Carro;



public interface CarroRepository extends JpaRepository<Carro,Long>{
    
}
