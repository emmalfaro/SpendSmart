
package com.spendsmart.controller;

import com.spendsmart.domain.Ingreso;
import com.spendsmart.services.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingreso")
public class IngresoController {
    
    
    @Autowired
    private IngresoService ingresoService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        
        var lista = ingresoService.getIngresos(false);
        
        model.addAttribute("ingresos", lista); 
        model.addAttribute("totalIngresos", lista.size());
        
        return "/ingreso/listado"; 
    }
    
    @PostMapping("/guardar")
    public String ingresoGuardar(Ingreso ingreso) {  
        ingresoService.save(ingreso);
        return "redirect:/ingreso/listado";
    }

    @GetMapping("/eliminar/{idIngreso}")
    public String ingresoEliminar(Ingreso ingreso) {
        ingresoService.delete(ingreso);
        return "redirect:/ingreso/listado";
    }

    @GetMapping("/modificar/{idIngreso}")
    public String ingresoModificar(Ingreso ingreso, Model model) {
        ingreso = ingresoService.getIngreso(ingreso);
        model.addAttribute("ingreso", ingreso);
        return "redirect:/ingreso/listado";
    }
    
    
}
