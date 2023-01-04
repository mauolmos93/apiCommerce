
package com.mauricio.apiCommerce.controller;

import com.mauricio.apiCommerce.model.Cliente;
import com.mauricio.apiCommerce.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    IClienteService cliServ;
    
    @GetMapping ("/clientes")
    public List<Cliente> getClients(){
        
        return cliServ.getClients();
    
    
    }
    
    @GetMapping ("clientes/{idCliente}")
    public Cliente findClient(@PathVariable Long idCliente){
        
        return cliServ.findClient(idCliente);
    }
    
    @PostMapping ("/clientes/crear")
    public String saveClient(@RequestBody Cliente cli){
        
        cliServ.saveClient(cli);
        return "El cliente fue creado correctamente";
    
    }
    
    @PutMapping ("clientes/editar/{idOriginal}")
    public Cliente editClient (@PathVariable Long idOriginal,
                               @RequestParam(required = false, name = "id")Long idNueva,
                               @RequestParam(required = false, name = "nombre")String nuevoNombre,
                               @RequestParam(required = false, name = "apellido")String nuevoApellido,
                               @RequestParam(required = false, name = "dni")String nuevoDni){
        
        cliServ.editClient(idOriginal, idNueva, nuevoNombre, nuevoApellido, nuevoDni);
        
        return this.findClient(idNueva);
    
    
    }
    
    @DeleteMapping ("/clientes/eliminar/{idCliente}")
    public String deleteClient (@PathVariable Long idCliente){
         
        cliServ.deleteClient(idCliente);
        return "El cliente fue eliminado correctamente";
    
    }
    
}
