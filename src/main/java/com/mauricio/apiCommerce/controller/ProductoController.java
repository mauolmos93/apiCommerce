
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService prodServ;
    
    @GetMapping ("/productos")
    @ResponseBody
    public List<Producto> getProductos (){
    
        return prodServ.getProducts();
    
    
    }
    
    @GetMapping ("/productos/{codigoProducto}")
    @ResponseBody
    public Producto findProduct (@PathVariable Long codigoProducto) {
    
        return prodServ.findProduct(codigoProducto);
    
    }
    
    @GetMapping ("/productos/falta_stock")
    @ResponseBody
    public List<Producto> getFaltaStock(){
        
        return prodServ.getFaltaStock();
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
                                 @RequestParam(required=false, name = "cantidadDisponible")Double nuevaCantidad,
                                 @RequestParam(required=false, name = "borrado")boolean nuevoBorrado){
        
        prodServ.editProduct(codigoOriginal, codigoNuevo, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad,nuevoBorrado);
        return prodServ.findProduct(codigoNuevo);
    
    
    }
    
    @PostMapping ("/productos/activate_logico/{codigoProducto}")
    public String activateProductLogic (@PathVariable Long codigoProducto) {
        prodServ.activateDeleteProductLogic(codigoProducto);
        
        return "El producto fue activado correctamente";
    
    }
    
    @DeleteMapping ("/productos/borrado_logico/{codigoProducto}")
    public String deleteProductLogic (@PathVariable Long codigoProducto) {
        prodServ.deleteProductLogic(codigoProducto);
        
        return "El producto fue borrado correctamente";
    }
    
    @DeleteMapping ("/productos/eliminar/{codigoProducto}")
    public String deleteProduct (@PathVariable Long codigoProducto) {
        
        prodServ.deleteProduct(codigoProducto);
        return "El producto fue eliminado correctamente";
    }
    
    
  
    
}
