
package com.mauricio.apiCommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    private boolean borrado;
    @ManyToMany
    @JoinTable(
                name = "ventaProducto",
                joinColumns = @JoinColumn (name = "codigoVenta", nullable = false),
                inverseJoinColumns = @JoinColumn (name = "codigoProducto", nullable = false)
    
    )
    private List<Producto> listaProductos;
    

    @OneToOne
    private Cliente Cli;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, boolean borrado, List<Producto> listaProductos, Cliente Cli) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.borrado = false;
        this.listaProductos = listaProductos;
        this.Cli = Cli;
    }




    
    
    
}
