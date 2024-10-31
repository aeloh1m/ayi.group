package com.demorest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demorest.Modelo.Sucursal;
import com.demorest.Repository.SucursalRepository;

import java.util.List;

@Controller
@RequestMapping("/sucursales") // Asegúrate de que esta anotación esté presente
public class SucursalController {

    @Autowired
    private SucursalRepository sucursalRepository;

    // Endpoint para listar sucursales y sus empleados
    @GetMapping
    public String listarSucursales(Model model) {
        List<Sucursal> sucursales = sucursalRepository.findAll();

        for (Sucursal sucursal : sucursales) {
            System.out.println("Sucursal: " + sucursal.getNombre() + ", Empleados: "
                    + (sucursal.getEmpleados() != null ? sucursal.getEmpleados().size() : 0));
        }

        model.addAttribute("sucursales", sucursales);
        return "sucursales";
    }
}
