package com.demorest.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Cliente {

    private int nroCliente;
    private String nombre;
    private String apellido;

    public int getNumeroCliente() {
        return nroCliente;
    }

}
