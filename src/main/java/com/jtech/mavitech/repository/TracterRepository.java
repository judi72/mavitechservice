package com.jtech.mavitech.repository;

import com.jtech.mavitech.entity.Tracter;
import com.jtech.mavitech.entity.TracterPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TracterRepository extends JpaRepository<Tracter, TracterPK> {
}
