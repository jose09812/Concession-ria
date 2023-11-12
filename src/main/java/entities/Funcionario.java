package entities;

import Enum.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data   
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Funcionario extends Pessoa {
    @Column(length = 11)
    private String ctps;
    private double salario;
    private Cargo cargo;
    @OneToMany(mappedBy = "funcionario")
    private Venda venda;

    public void setFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado){
        funcionarioAntigo.setCpf(funcionarioAtualizado.getCpf());
        funcionarioAntigo.setData_nascimento(funcionarioAtualizado.getData_nascimento());
        funcionarioAntigo.setNome(funcionarioAtualizado.getNome());
        funcionarioAntigo.setTelefone(funcionarioAtualizado.getTelefone());
        funcionarioAntigo.setCargo(funcionarioAtualizado.getCargo());
        funcionarioAntigo.setCtps(funcionarioAtualizado.getCtps());
        funcionarioAntigo.setSalario(funcionarioAtualizado.getSalario());
    }
    
}
