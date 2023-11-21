package concessionaria.concessionaria.entities;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;

import concessionaria.concessionaria.Enum.Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carros")
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Modelo modeloCarro;
    private String numeroChassi;
    private double valor;
    private boolean carroNovo;
    private boolean carroDisponivel;
    private LocalDate anoLancamento;
    private LocalDate dataVenda;
    @OneToOne(mappedBy = "carro")
    private Venda venda;
    
    public Carro getCarroByChassi( List <Carro> carros, String chassi){
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getNumeroChassi().equals(chassi)) {
                return carros.get(i);
                
            }
            
        }
        return null;


        

    }
   
    public void verificacao(Funcionario funcionario){
        

    }
    public void setCarro(Carro carroAntigo, Carro carroAtualizado){
          try {
        BeanUtils.copyProperties(carroAntigo, carroAtualizado);
    } catch (Exception e) {
       
    }
    }
}