package entities;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data   
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Funcionario extends Pessoa {
    private String ctps;
    private String cargo;
    private double salario;
    @OneToMany(mappedBy = "funcionario")
    private Venda venda;
}
