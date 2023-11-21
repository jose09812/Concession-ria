package concessionaria.concessionaria.entities;




import java.util.List;

import org.springframework.beans.BeanUtils;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "clientes", uniqueConstraints = {@UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),
@UniqueConstraint(name = "telefone_ukey", columnNames = "telefone") })
public class Cliente extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String infoCadastro;
    private double saldo;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venda>  vendas;
    
    public boolean getClienteById(Cliente cliente){
        //criar uma forma de limitar o acesso das pessoas 
        return true;
    }
    public void setCliente(Cliente clienteAntigo, Cliente clienteAtualizado){
         try {
        BeanUtils.copyProperties(clienteAntigo, clienteAtualizado);
    } catch (Exception e) {
       
    }
    }
    

    
}
