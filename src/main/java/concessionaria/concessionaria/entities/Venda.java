package concessionaria.concessionaria.entities;


import java.time.LocalDate;
import java.util.List;

import concessionaria.concessionaria.Enum.Modelo;
import concessionaria.concessionaria.Enum.TipoPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "cliente_fkey"))
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "funcionario", foreignKey = @ForeignKey(name = "funcionario_fkey"))
    private Funcionario funcionario;
    @OneToOne
    @JoinColumn(name = "carro", foreignKey = @ForeignKey (name = "carro_fkey"))
    private Carro carro;
    private double valor;
    private LocalDate dataCompra;
    private TipoPagamento formaPagamento;
    private String numeroPlaca;
    private boolean vendaConcluida;

    public void setVenda(Venda vendaAntiga, Venda vendaAtualizada){
        vendaAntiga.setCarro(vendaAtualizada.getCarro());
        vendaAntiga.setCliente(vendaAtualizada.getCliente());
        vendaAntiga.setFuncionario(vendaAtualizada.getFuncionario());
        vendaAntiga.setDataCompra(vendaAtualizada.getDataCompra());
        vendaAntiga.setNumeroPlaca(vendaAtualizada.getNumeroPlaca());
        vendaAntiga.setValor(vendaAtualizada.getValor());
    }
    public double valorTotalVenda(List<Venda> vendas){
        double valor=0;
        for(int i = 0;i<vendas.size();i++){
            valor += vendas.get(i).getValor();

        }
        return valor;
    }
    public double vendaTotalPorModelo(List<Venda> vendas, Modelo moldelo ){
        double valor =0;
        for (int i = 0; i < vendas.size(); i++) {
            if(moldelo.equals(vendas.get(i).getCarro().getModeloCarro())  ){
                valor += vendas.get(i).getValor();
                
            } 
            
        }
        return valor;
    }
    public Integer numeroTotalVendas(List<Venda> vendas){
        int valor = vendas.size();
        return valor;
    }
    public Integer numeroVendasPorModelo(List<Venda> vendas, Modelo moldelo ){
        int valor =0;
        for (int i = 0; i < vendas.size(); i++) {
            if(moldelo.equals(vendas.get(i).getCarro().getModeloCarro())  ){
            valor +=i;
                
            } 
            
        }
        return valor;
    }
    // public Venda topVendedores(List<Venda> vendas){
    //     List <Venda> topVendedores;


        

    // }
    }
