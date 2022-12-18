
package com.mauricio.apiCommerce.repository;

import com.mauricio.apiCommerce.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
    
}
