package com.demorest.Repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demorest.Modelo.Sucursal;
import java.util.List;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    @EntityGraph(attributePaths = { "empleados" })
    List<Sucursal> findAll();
}
