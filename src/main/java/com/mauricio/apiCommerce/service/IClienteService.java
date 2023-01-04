
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveClient(Cliente cli);
    public List<Cliente> getClients();
    public Cliente findClient(Long idCliente);
    public void deleteClient(Long idCliente);
    public void editClient(Long idOriginal, Long idNueva, 
                           String nuevoNombre, String nuevoApellido, String nuevoDni);
    
    
}
