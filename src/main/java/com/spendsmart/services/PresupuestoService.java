
package com.spendsmart.services;

import com.spendsmart.domain.Presupuesto;
import java.util.List;


public interface PresupuestoService {

    public List<Presupuesto> getPresupuestos(boolean activos);
    
    public Presupuesto getPresupuesto(Presupuesto presupuesto);
    
    public void save(Presupuesto presupuesto);
    
    public void delete(Presupuesto presupuesto);
}
