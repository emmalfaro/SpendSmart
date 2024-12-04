
package com.spendsmart.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @GetMapping("/listado")
    public String listado(Model model) {
        
        
        return "/categoria/listado"; 
    }
    
}
