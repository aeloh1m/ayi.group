package com.demoMVC.demoMVC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    private String codigoProveedor; 
    private String razonSocial;  
    private String cuilCuit;        
    private String domicilioCalle;   
    private String domicilioAltura; 
    private String tipoProveedor;     
}

