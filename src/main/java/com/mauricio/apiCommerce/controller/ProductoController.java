
package com.mauricio.apiCommerce.controller;


import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    IProductoService prodServ;
    
    @GetMapping ("/productos")
    public List<Producto> getProductos (){
    
        return prodServ.getProducts();
    
    
    }
    
    @GetMapping ("productos/{codigoProducto}")
    public Producto findProduct (@PathVariable Long codigoProducto) {
    
        return prodServ.findProduct(codigoProducto);
    
    }
    
    @PostMapping ("/productos/crear")
    public String saveProduct (@RequestBody Producto product){
        
        prodServ.saveProduct(product);
        return "El producto fue creado correctamente";
    
    
    }
    
    @PutMapping ("/productos/editar/{codigoOriginal}")
    public Producto editProduct (@PathVariable Long codigoOriginal,
                                 @RequestParam(required=false, name = "codigoProducto")Long codigoNuevo,
                                 @RequestParam(required=false, name = "nombre")String nuevoNombre,
                                 @RequestParam(required=false, name = "marca")String nuevaMarca,
                                 @RequestParam(required=false, name = "costo")Double nuevoCosto,
                                 @RequestParam(required=false, name = "cantidadDisponible")Double nuevaCantidad){
        
        prodServ.editProduct(codigoOriginal, codigoNuevo, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad);
        return prodServ.findProduct(codigoNuevo);
    
    
    }
    
    @DeleteMapping ("/productos/eliminar/{codigoProducto}")
    public String deleteProduct (@PathVariable Long codigoProducto) {
        
        prodServ.deleteProduct(codigoProducto);
        return "El producto fue eliminado correctamente";
    }
    
    
  
    
}
