package com.demorest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demorest.Modelo.Empleado;
import com.demorest.Repository.EmpleadoRepository;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository usuarioRepository;

    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = usuarioRepository.findAll();
        model.addAttribute("titulo", "Listado de Empleados");
        model.addAttribute("empleados", empleados);
        return "empleados"; // Este nombre debe coincidir con 'empleados.html'
    }

    @GetMapping("/test-usuarios")
    public String testUsuarios() {
        List<Empleado> usuarios = usuarioRepository.findAll();
        System.out.println(usuarios); // Imprimir en la consola
        return "hello"; // Asegúrate de tener una vista para esto, o cambia a "/usuarios"
    }

}
