package com.jtech.mavitech.repository;

import com.jtech.mavitech.entity.Visitetechnique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface VisitetechniqueRepository extends JpaRepository<Visitetechnique, Long> {
}
