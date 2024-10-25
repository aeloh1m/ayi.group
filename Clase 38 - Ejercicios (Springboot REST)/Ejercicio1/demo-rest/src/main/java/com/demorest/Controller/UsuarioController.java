package com.demorest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.demorest.Modelo.Usuario;
import com.demorest.Repository.UsuarioRepository;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", usuarios);
        return "usuarios"; // Este nombre debe coincidir con 'usuarios.html'
    }

    @GetMapping("/test-usuarios")
    public String testUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println(usuarios); // Imprimir en la consola
        return "hello"; // Asegúrate de tener una vista para esto, o cambia a "/usuarios"
    }

}
