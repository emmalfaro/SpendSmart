
package com.spendsmart.controller;

import com.spendsmart.domain.Presupuesto;
import com.spendsmart.services.CategoriaService;
import com.spendsmart.services.PresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/presupuesto")
public class PresupuestoController {
    
    
    @Autowired
    private PresupuestoService presupuestoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/listado")
    public String listado(Model model) {
        
        var lista = presupuestoService.getPresupuestos(false);
        
        model.addAttribute("presupuestos", lista); 
        
        // pasar lista de categorias:
        var categorias=categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias); 
        
        return "/presupuesto/listado"; 
    }
    
    @PostMapping("/guardar")
    public String presupuestoGuardar(Presupuesto presupuesto) {  
        presupuestoService.save(presupuesto);
        return "redirect:/presupuesto/listado";
    }

    @GetMapping("/eliminar/{idPresupuesto}")
    public String presupuestoEliminar(Presupuesto presupuesto) {
        presupuestoService.delete(presupuesto);
        return "redirect:/presupuesto/listado";
    }

    @GetMapping("/modificar/{idPresupuesto}")
    public String presupuestoModificar(Presupuesto presupuesto, Model model) {
        presupuesto = presupuestoService.getPresupuesto(presupuesto);
        model.addAttribute("presupuesto", presupuesto);
        return "redirect:/presupuesto/listado";
    }
    
    
}
