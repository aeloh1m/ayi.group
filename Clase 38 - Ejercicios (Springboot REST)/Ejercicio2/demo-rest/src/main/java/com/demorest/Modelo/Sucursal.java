package com.demorest.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.demorest.Modelo.Sucursal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursales") // Asegúrate de que este nombre sea correcto
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_sucursal;
    private String nombre;
    private String direccion;
    private String barrio;

    @OneToMany(mappedBy = "sucursal", fetch = FetchType.LAZY)
    private List<Empleado> empleados;
}
