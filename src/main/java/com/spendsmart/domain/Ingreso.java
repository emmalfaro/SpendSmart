
package com.spendsmart.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;


@Data 
@Entity 
@Table(name="ingresos")
public class Ingreso implements Serializable{
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idIngreso;
    private Double monto;
    private String descripcion; 
    @Column(name = "fecha_ingreso", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaIngreso;
    
}

