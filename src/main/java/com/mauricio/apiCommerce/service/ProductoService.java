
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.repository.IProductoRepository;
import java.util.ArrayList;
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
        
        List<Producto> listProdu = productoRepo.findAll();
        List<Producto> listProdu2 = new ArrayList<>();
        
        for (Producto produ : listProdu) {
            if (produ.isBorrado() == false) {
                
                listProdu2.add(produ);
            }
        
        }
        
        return listProdu2;
        
    }

    @Override
    public Producto findProduct(Long codigoProducto) {
        
        return productoRepo.findById(codigoProducto).orElse(null);
        
        
       
    }

    @Override
    public void deleteProduct(Long codigoProducto) {
        
        productoRepo.deleteById(codigoProducto);
        
    }

    @Override
    public void editProduct(Long codigoOriginal, Long codigoNuevo, 
                            String nuevoNombre, String nuevaMarca, 
                            Double nuevoCosto, Double nuevaCantidadDisponible, boolean borrado) {
        Producto prod = this.findProduct(codigoOriginal);
        
        prod.setCodigoProducto(codigoNuevo);
        prod.setNombre(nuevoNombre);
        prod.setMarca(nuevaMarca);
        prod.setCosto(nuevoCosto);
        prod.setCantidadDisponible(nuevaCantidadDisponible);
        prod.setBorrado(borrado);
        
        this.saveProduct(prod);
       
    }

    @Override
    public void deleteProductLogic(Long codigoProducto) {
        this.findProduct(codigoProducto).setBorrado(true);
        productoRepo.flush();
        
    }

    @Override
    public void activateDeleteProductLogic(Long codigoProducto) {
        this.findProduct(codigoProducto).setBorrado(false);
        productoRepo.flush();
       
    }

    @Override
    public List<Producto> getFaltaStock() {
        List<Producto> listProduct = this.getProducts();
        List<Producto> listFaltaStock = new ArrayList<>();
        
        for (Producto produ : listProduct) {
            if (produ.getCantidadDisponible() < 5 ) {
                
                listFaltaStock.add(produ);
                
            }
        
        }
        return listFaltaStock;
    }
    
}
