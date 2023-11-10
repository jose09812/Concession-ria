package entities;

import java.io.DataInput;

import Enum.TipoPagamento;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Venda {
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    @OneToOne
    private Carro carro;
    private double valor;
    private DataInput dataCompra;
    private TipoPagamento formaPagamento;
    private String numeroPlaca;

    
}
