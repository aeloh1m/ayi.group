package com.demorest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demorest.Modelo.Empleado;
import  java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("SELECT e FROM Empleado e JOIN e.sucursal s WHERE s.id = :sucursalId")
    List<Empleado> findEmpleadosBySucursalId(@Param("sucursalId") Long sucursalId);
}
