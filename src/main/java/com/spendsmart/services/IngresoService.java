
package com.spendsmart.services;

import com.spendsmart.domain.Ingreso;
import java.util.List;


public interface IngresoService {

    public List<Ingreso> getIngresos(boolean activos);
    
    public Ingreso getIngreso(Ingreso ingreso);
    
    public void save(Ingreso ingreso);
    
    public void delete(Ingreso ingreso);
}
