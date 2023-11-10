package entities;

import java.io.DataInput;

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
    private DataInput anoLancamento;
    private double valor;
    private boolean carroNovo;
    @OneToOne(mappedBy = "carro")
    private Venda venda;
    
}
