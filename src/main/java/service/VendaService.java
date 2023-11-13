package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Enum.Modelo;
import entities.Venda;

import repository.VendaRepository;



public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;
    // @Autowired
    // private CarroRepository carroRepository;
    // public Venda getCarroByChassi(String chassi){
    // List<Carro> venda =carroRepository.findAll();
    // } verificar texto que esta no main para tirar duvidas sobre isso 
   
    public List<Venda> getAllVendas(){
        List<Venda> vendas = vendaRepository.findAll();
        return vendas;
        
    }

    public Venda getVendaById(Long id ){
        Venda venda = vendaRepository.findById(id).orElse(null);

        return venda;

    }
    public Venda saveVenda(Venda venda ){
        Venda novoVenda = vendaRepository.save(venda);
        return novoVenda;
    }
    public Venda updateVenda(Long id, Venda vendaAtualizada ){
        Venda vendaExistente = vendaRepository.findById(id).orElse(null);
        vendaExistente.setVenda(vendaExistente, vendaAtualizada);
        vendaRepository.save(vendaExistente);
        return vendaExistente;

    }
    public Venda deleteLogical(Long id){
        Venda venda = vendaRepository.findById(id).orElse(null);
        venda.setVendaConcluida(false);
        return venda;

    }
    public double valorTotalVenda(){
        List<Venda> vendas = vendaRepository.findAll();
        Venda venda = new Venda();
        double vendaTotal = venda.valorTotalVenda(vendas);
        return vendaTotal;

    }
    public double vendaTotalPorModelo( Modelo modelo){
        List<Venda> vendas = vendaRepository.findAll();
        Venda venda = new Venda();
        double vendaPorModelo = venda.vendaTotalPorModelo(vendas, modelo);
        return vendaPorModelo;
    }
    public Integer numeroTotalVendas(){
        List<Venda> vendas = vendaRepository.findAll();
        Venda venda = new Venda();
        int numeroTotalVendas = venda.numeroTotalVendas(vendas);
        return numeroTotalVendas;
    }
    public Integer numeroVendasPorModelo(Modelo modelo){
        List<Venda> vendas = vendaRepository.findAll();
        Venda venda = new Venda();
        int numeroVendasPorModelo = venda.numeroVendasPorModelo(vendas,modelo);
        return numeroVendasPorModelo;
    }
}
