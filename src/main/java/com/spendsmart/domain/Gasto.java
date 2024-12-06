
package com.spendsmart.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;


@Data 
@Entity 
@Table(name="gastos")
public class Gasto implements Serializable{
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idGasto;
  //  private Long idCategoria;
    private Double monto;
    private String descripcion; 
    @Column(name = "fecha_gasto", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaGasto;
    
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
}
