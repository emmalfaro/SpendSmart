
package com.spendsmart.dao;

import com.spendsmart.domain.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface GastoDao
                            extends JpaRepository<Gasto,Long> {
    
}
