
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.model.Cliente;
import com.mauricio.apiCommerce.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ClienteService implements IClienteService {
    
    @Autowired
    IClienteRepository repoCli;

    @Override
    public void saveClient(Cliente cli) {
        repoCli.save(cli);
    }

    @Override
    public List<Cliente> getClients() {
        return repoCli.findAll();
    }

    @Override
    public Cliente findClient(Long idCliente) {
        
        Cliente cli = repoCli.findById(idCliente).orElse(null);
        return cli;
        
    }

    @Override
    public void deleteClient(Long idCliente) {
        
        repoCli.deleteById(idCliente);
        
    }

    @Override
    public void editClient(Long idOriginal, Long idNueva, 
                           String nuevoNombre, String nuevoApellido, String nuevoDni) {
        
        Cliente cli = this.findClient(idOriginal);
        
        cli.setIdCliente(idNueva);
        cli.setNombre(nuevoNombre);
        cli.setApellido(nuevoApellido);
        cli.setDni(nuevoDni);
        
        this.saveClient(cli);
        
    }
    
}
