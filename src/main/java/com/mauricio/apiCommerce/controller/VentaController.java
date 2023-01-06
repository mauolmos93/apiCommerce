
package com.mauricio.apiCommerce.controller;

import com.mauricio.apiCommerce.dto.MayorVentaDTO;
import com.mauricio.apiCommerce.model.Cliente;
import com.mauricio.apiCommerce.model.Producto;
import com.mauricio.apiCommerce.model.Venta;
import com.mauricio.apiCommerce.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    IVentaService venServ;
    
    @GetMapping ("/ventas")
    @ResponseBody
    public List<Venta> listarVentas (){
        
        return venServ.listarVentas();
        
    }
    
    @GetMapping ("/ventas/{codigoVenta}")
    @ResponseBody
    public Venta buscarVenta(@PathVariable Long codigoVenta){
        
        return venServ.buscarVenta(codigoVenta);
    }
    
    @GetMapping ("/ventas/productos/{codigoVenta}")
    public List<Producto> listarProductosVenta (@PathVariable Long codigoVenta){
        
        return venServ.listarProductosVenta(codigoVenta);
    }
    
    @GetMapping ("/ventas/monto/{fechaVenta}")
    @ResponseBody
    public String obtenerMontoCantidad (@PathVariable String fechaVenta) {
        
        LocalDate fecha = LocalDate.parse(fechaVenta);
        
        return venServ.obtenerMontoCantidad(fecha);
    
    }
    
    @GetMapping ("/ventas/mayo_venta")
    @ResponseBody
    public MayorVentaDTO obtenerMayorVenta () {
        
        return venServ.obtenerMayorVenta();
    
    }
    
    @PostMapping ("/ventas/crear")
    public String crearVenta (@RequestBody Venta ven){
        
        venServ.crearVenta(ven);
        return "La venta se creo correctamente";
    }
    
    @PutMapping ("/ventas/editar/{codigoVenta}")
    public Venta editarVenta (@PathVariable Long codigoOriginal,
                              @RequestParam(required=false,name="codigoVenta")Long codigoNuevo,
                              @RequestParam(required=false,name="fechaVenta")LocalDate nuevaFechaVent,
                              @RequestParam(required=false,name="total")Double nuevoTotal,
                              @RequestParam(required=false,name="borrado")boolean nuevoBorrado,
                              @RequestParam(required=false,name="listaProdu")List<Producto> nuevaListaProdu,
                              @RequestParam(required=false,name="cliente")Cliente nuevoCli){
        
        venServ.editarVenta(codigoOriginal, codigoNuevo, nuevaFechaVent, nuevoTotal, nuevoBorrado, nuevaListaProdu, nuevoCli);
        return venServ.buscarVenta(codigoNuevo);
        
    
    }
    
    @PostMapping ("/ventas/activar_logico/{codigoVenta}")
    public String activarVentaLogic(@PathVariable Long codigoVenta){
        
        venServ.activarVentaLogic(codigoVenta);
        return "La venta fue activada correctamente";
    }
    
    @DeleteMapping ("/ventas/borrado_logico/{codigoVenta}")
    public String borrarVentaLogic(@PathVariable Long codigoVenta){
        
        venServ.borrarVentaLogic(codigoVenta);
        return "La venta fue borrada correctamente";
    }
    
    @DeleteMapping ("/ventas/eliminar/{codigoVenta}")
    public String eliminarVenta(@PathVariable Long codigoVenta){
        
        venServ.eliminarVenta(codigoVenta);
        return "La venta fue eliminada correctamente";
    
    }
    
}
