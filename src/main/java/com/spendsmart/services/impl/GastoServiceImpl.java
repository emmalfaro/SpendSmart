
package com.spendsmart.services.impl;

import com.spendsmart.dao.GastoDao;
import com.spendsmart.domain.Gasto;
import com.spendsmart.services.GastoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GastoServiceImpl implements GastoService {
    
    @Autowired
    private GastoDao gastoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Gasto> getGastos(boolean activos) {
        var lista = gastoDao.findAll();

        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Gasto getGasto(Gasto gasto) {
        return gastoDao.findById(gasto.getIdGasto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Gasto gasto){
        gastoDao.save(gasto);
        
    }
    
    @Override
    @Transactional
    public void delete(Gasto gasto){
        gastoDao.delete(gasto);
        
    }
    
}
