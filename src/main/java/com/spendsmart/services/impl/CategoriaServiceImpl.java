
package com.spendsmart.services.impl;

import com.spendsmart.dao.CategoriaDao;
import com.spendsmart.domain.Categoria;
import com.spendsmart.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    public List<Categoria> getCategorias() {
        var lista = categoriaDao.findAll();

        return lista;
    }
    
    
}
