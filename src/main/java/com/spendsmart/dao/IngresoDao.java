
package com.spendsmart.dao;

import com.spendsmart.domain.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface IngresoDao
                            extends JpaRepository<Ingreso,Long> {
    
}
