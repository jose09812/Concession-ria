package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.Cliente;
import repository.ClienteRepository;




@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
        
    }

    public Cliente getClienteById(Long id ){
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        return cliente;

    }
    public Cliente saveCliente(Cliente cliente ){
        Cliente novoCliente = clienteRepository.save(cliente);
        return novoCliente;
    }
    public Cliente updateCliente(Long id, Cliente clienteAtualizado ){
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        clienteExistente.setCliente(clienteExistente, clienteAtualizado);
        clienteRepository.save(clienteExistente);
        return clienteExistente;

    }
    public Cliente deleteLogical(Long id){
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        cliente.setAtivo(false);
        return cliente;

    }

}
