
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProduct(Producto product);
    public List<Producto> getProducts();
    public Producto findProduct(Long codigoProducto);
    public void deleteProduct(Long codigoProducto);
    public void editProduct(Long codigoOriginal, Long codigoNuevo, 
                            String nuevoNombre, String nuevaMarca,
                            Double nuevoCosto, Double nuevaCantidadDisponible);
    
}
