package entities;

import org.springframework.beans.BeanUtils;

import Enum.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data   
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {
    @Column(length = 11)
    private String ctps;
    private double salario;
    private Cargo cargo;
    @OneToMany(mappedBy = "funcionario")
    private Venda venda;

    public void setFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado){
          try {
        BeanUtils.copyProperties(funcionarioAntigo, funcionarioAtualizado);
    } catch (Exception e) {
       
    }
    }
    
}
