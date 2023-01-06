
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.dto.MayorVentaDTO;
import com.mauricio.apiCommerce.model.Cliente;
import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public List<Venta> listarVentas ();
    
    public Venta buscarVenta(Long codigoVenta);
    
    public void crearVenta(Venta ven);
    
    public void eliminarVenta(Long codigoVenta);
    
    public void borrarVentaLogic(Long codigoVenta);
    
    public void activarVentaLogic(Long codigoVenta);
    
    public List<Producto> listarProductosVenta(Long codigoVenta);
    
    public String obtenerMontoCantidad (LocalDate fechaVenta);
    
    public void editarVenta(Long codigoOriginal, Long codigoNuevo,
                            LocalDate nuevaFechaVenta, Double nuevoTotal, boolean nuevoBorrado,
                            List<Producto> nuevaListaProdu, Cliente nuevoCli);
    
    public MayorVentaDTO obtenerMayorVenta ();
    
}
