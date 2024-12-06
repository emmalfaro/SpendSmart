
package com.spendsmart.services.impl;

import com.spendsmart.dao.IngresoDao;
import com.spendsmart.domain.Ingreso;
import com.spendsmart.services.IngresoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class IngresoServiceImpl implements IngresoService {
    
    @Autowired
    private IngresoDao ingresoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Ingreso> getIngresos(boolean activos) {
        var lista = ingresoDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Ingreso getIngreso(Ingreso ingreso) {
        return ingresoDao.findById(ingreso.getIdIngreso()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Ingreso ingreso){
        ingresoDao.save(ingreso);
        
    }
    
    @Override
    @Transactional
    public void delete(Ingreso ingreso){
        ingresoDao.delete(ingreso);
        
    }
    
}
