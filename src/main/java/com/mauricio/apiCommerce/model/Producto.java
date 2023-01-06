
package com.mauricio.apiCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@JsonIgnoreProperties("listaVentas") // esta anotation hace que en las solicitudes  "Get", no muestre la lista de ventas dentro de cada producto.
public class Producto {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;
    private boolean borrado;
    @ManyToMany(mappedBy="listaProductos")
    @JsonIgnore
    private List<Venta>listaVentas;
  

    public Producto() {
    }

    public Producto(Long codigoProducto, String nombre, String marca, Double costo, Double cantidadDisponible, boolean borrado, List<Venta> listaVentas) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidadDisponible = cantidadDisponible;
        this.borrado = false;
        this.listaVentas = listaVentas;
    }

   


    
    
    
}
