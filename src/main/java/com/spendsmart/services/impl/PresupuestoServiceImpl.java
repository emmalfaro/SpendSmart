
package com.spendsmart.services.impl;

import com.spendsmart.dao.PresupuestoDao;
import com.spendsmart.domain.Presupuesto;
import com.spendsmart.services.PresupuestoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PresupuestoServiceImpl implements PresupuestoService {
    
    @Autowired
    private PresupuestoDao presupuestoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Presupuesto> getPresupuestos(boolean activos) {
        var lista = presupuestoDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Presupuesto getPresupuesto(Presupuesto presupuesto) {
        return presupuestoDao.findById(presupuesto.getIdPresupuesto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Presupuesto presupuesto){
        presupuestoDao.save(presupuesto);
        
    }
    
    @Override
    @Transactional
    public void delete(Presupuesto presupuesto){
        presupuestoDao.delete(presupuesto);
        
    }
    
}
