
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public void saveProduct(Producto product) {
        
        productoRepo.save(product);
        
    }

    @Override
    public List<Producto> getProducts() {
        
        return productoRepo.findAll();
        
    }

    @Override
    public Producto findProduct(Long codigoProducto) {
        
        Producto product = productoRepo.findById(codigoProducto).orElse(null);
        return product;
       
    }

    @Override
    public void deleteProduct(Long codigoProducto) {
        
        productoRepo.deleteById(codigoProducto);
        
    }

    @Override
    public void editProduct(Long codigoOriginal, Long codigoNuevo, 
                            String nuevoNombre, String nuevaMarca, 
                            Double nuevoCosto, Double nuevaCantidadDisponible) {
        Producto prod = this.findProduct(codigoOriginal);
        
        prod.setCodigoProducto(codigoNuevo);
        prod.setNombre(nuevoNombre);
        prod.setMarca(nuevaMarca);
        prod.setCosto(nuevoCosto);
        prod.setCantidadDisponible(nuevaCantidadDisponible);
        
        this.saveProduct(prod);
       
    }
    
}
