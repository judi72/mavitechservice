package com.jtech.mavitech.repository;

import com.jtech.mavitech.entity.Remorque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface RemorqueRepository extends JpaRepository<Remorque, Long> {
}
