
package com.spendsmart.services;

import com.spendsmart.domain.Gasto;
import java.util.List;


public interface GastoService {

    public List<Gasto> getGastos(boolean activos);
    
    public Gasto getGasto(Gasto gasto);
    
    public void save(Gasto gasto);
    
    public void delete(Gasto gasto);
}
