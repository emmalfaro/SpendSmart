
package com.spendsmart.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;


@Data 
@Entity 
@Table(name="presupuestos")
public class Presupuesto implements Serializable{
    
    private static final long serialVersionUID = 11;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long idPresupuesto;
   // private Long idCategoria;
    private double monto;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    
}

/*
CREATE TABLE presupuestos (
    id_presupuesto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_presupuestos_categorias FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria))

*/

