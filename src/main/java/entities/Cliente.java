package entities;


import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Table(name =  "clientes", uniqueConstraints = {@UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),
@UniqueConstraint(name = "telefone_ukey", columnNames = "telefone") })
public class Cliente extends Pessoa{
    private String infoCadastro;
    private double saldo;
    @OneToMany(mappedBy = "cliente")
    private Venda venda;
    
    public boolean getClienteById(Cliente cliente){
        //criar uma forma de limitar o acesso das pessoas 
        return true;
    }
    public void setCliente(Cliente clienteAntigo, Cliente clienteAtualizado){
        clienteAntigo.setCpf(clienteAtualizado.getCpf());
        clienteAntigo.setData_nascimento(clienteAtualizado.getData_nascimento());
        clienteAntigo.setNome(clienteAtualizado.getNome());
        clienteAntigo.setTelefone(clienteAtualizado.getTelefone());
        clienteAntigo.setSaldo(clienteAtualizado.getSaldo());
    }
    public Cliente(){}
}
