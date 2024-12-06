
package com.spendsmart.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;


@Data 
@Entity 
@Table(name="categorias")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idCategoria;
    private String nombreCategoria;
    
    @OneToMany 
    @JoinColumn(name="id_categoria", updatable = false)
    private List<Gasto> gastos;
    
    
}



