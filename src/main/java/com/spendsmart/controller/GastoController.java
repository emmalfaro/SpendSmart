
package com.spendsmart.controller;

import com.spendsmart.domain.Gasto;
import com.spendsmart.services.CategoriaService;
import com.spendsmart.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gasto")
public class GastoController {
    
    
    @Autowired
    private GastoService gastoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        
        var lista = gastoService.getGastos(false);
        
        model.addAttribute("gastos", lista); 
        model.addAttribute("totalGastos", lista.size());
        
        // pasar lista de categorias:
        var categorias=categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias); 
        
        return "/gasto/listado"; 
    }
    
    @PostMapping("/guardar")
    public String gastoGuardar(Gasto gasto) {  
        gastoService.save(gasto);
        return "redirect:/gasto/listado";
    }

    @GetMapping("/eliminar/{idGasto}")
    public String gastoEliminar(Gasto gasto) {
        gastoService.delete(gasto);
        return "redirect:/gasto/listado";
    }

    @GetMapping("/modificar/{idGasto}")
    public String gastoModificar(Gasto gasto, Model model) {
        gasto = gastoService.getGasto(gasto);
        model.addAttribute("gasto", gasto);
        return "redirect:/gasto/listado";
    }
    
    
}
