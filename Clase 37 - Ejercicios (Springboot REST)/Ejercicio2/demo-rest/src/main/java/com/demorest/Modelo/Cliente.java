package com.demorest.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    private int nro_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
}
