package com.demoMVC.demoMVC.Controller;

import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.demoMVC.demoMVC.Model.Proveedor;

import org.springframework.stereotype.Controller;

@Controller
public class ProveedorController {
    @GetMapping("/proveedores")
    public String indexH1(Model model) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(new Proveedor("123", "Proveedor 1", "1234567890", "Calle 123", "456", "Tipo A"));
        proveedores.add(new Proveedor("456", "Proveedor 2", "9876543210", "Calle 456", "789", "Tipo B"));
        proveedores.add(new Proveedor("789", "Proveedor 3", "5555555555", "Calle 789", "123", "Tipo C"));
        model.addAttribute("proveedores", proveedores);
        return "proveedores";
    }
}
