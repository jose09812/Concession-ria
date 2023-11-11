package entities;

import java.io.DataInput;
import java.util.List;

import Enum.Modelo;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Carro {
    private Modelo modeloCarro;
    private String numeroChassi;
    private double valor;
    private boolean carroNovo;
    private boolean carroDisponivel;
    private DataInput anoLancamento;
    private DataInput dataVenda;
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
    public Carro(){

    }
    public void verificacao(Funcionario funcionario){
        

    }
}