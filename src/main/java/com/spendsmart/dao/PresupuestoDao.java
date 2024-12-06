
package com.spendsmart.dao;

import com.spendsmart.domain.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface PresupuestoDao
                            extends JpaRepository<Presupuesto,Long> {
    
}
