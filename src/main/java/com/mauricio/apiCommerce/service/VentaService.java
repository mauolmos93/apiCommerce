
package com.mauricio.apiCommerce.service;

import com.mauricio.apiCommerce.dto.MayorVentaDTO;
import com.mauricio.apiCommerce.model.Cliente;
import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.model.Venta;
import com.mauricio.apiCommerce.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    IVentaRepository repoVenta;

    @Override
    public List<Venta> listarVentas() {
        
        return repoVenta.findAll();
       
    }

    @Override
    public Venta buscarVenta(Long codigoVenta) {
        
        return repoVenta.findById(codigoVenta).orElse(null);
    }

    @Override
    public void crearVenta(Venta ven) {
        
        repoVenta.save(ven);
        
    }

    @Override
    public void eliminarVenta(Long codigoVenta) {
        
        repoVenta.deleteById(codigoVenta);
        
    }

    @Override
    public void editarVenta(Long codigoOriginal, Long codigoNuevo,
                            LocalDate nuevaFechaVenta, Double nuevoTotal, boolean nuevoBorrado,
                            List<Producto> nuevaListaProdu, Cliente nuevoCli) {
        
        Venta ven = this.buscarVenta(codigoOriginal);
        ven.setCodigoVenta(codigoNuevo);
        ven.setFechaVenta(nuevaFechaVenta);
        ven.setTotal(nuevoTotal);
        ven.setBorrado(nuevoBorrado);
        ven.setListaProductos(nuevaListaProdu);
        ven.setCli(nuevoCli);
        
        this.crearVenta(ven);
        
    }

    @Override
    public void borrarVentaLogic(Long codigoVenta) {
        
        this.buscarVenta(codigoVenta).setBorrado(true);
        repoVenta.flush();
        
    }

    @Override
    public void activarVentaLogic(Long codigoVenta) {
        
        this.buscarVenta(codigoVenta).setBorrado(false);
        repoVenta.flush();        
    }

    @Override
    public List<Producto> listarProductosVenta(Long codigoVenta) {
        
        Venta venta = this.buscarVenta(codigoVenta);
        return venta.getListaProductos();
    }

    @Override
    public String obtenerMontoCantidad(LocalDate fechaVenta) {
        
        double monto = 0;
        int cantidad = 0;
        List<Venta> listaVentas = this.listarVentas();
        
        for (Venta venta : listaVentas) {
            
            if (venta.getFechaVenta().equals(fechaVenta)) {
                monto = monto + venta.getTotal();
                cantidad++;
            }
        }
        return "La cantidad de ventas del dia "+fechaVenta+ " es de: "+cantidad+" , con un monto total de: "+monto;
    }

    @Override
    public MayorVentaDTO obtenerMayorVenta() {
        List<Venta> listaVentas = this.listarVentas();
        Venta venta = new Venta();
        venta.setTotal(0.0);
        
        for (Venta venta2 : listaVentas) {
            if (venta2.getTotal() > venta.getTotal()) {
                venta = venta2;
            }
        }
        
        MayorVentaDTO mayorVenta = new MayorVentaDTO();
        
        mayorVenta.setCodigoVenta(venta.getCodigoVenta());
        mayorVenta.setTotal(venta.getTotal());
        mayorVenta.setCantidadProductos(venta.getListaProductos().size());
        mayorVenta.setNombreCliente(venta.getCli().getNombre());
        mayorVenta.setApellidoCliente(venta.getCli().getApellido());
        
        return mayorVenta;
    }

 
}
