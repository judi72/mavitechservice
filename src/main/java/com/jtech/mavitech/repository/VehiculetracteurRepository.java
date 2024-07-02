package com.jtech.mavitech.repository;

import com.jtech.mavitech.entity.Vehiculetracteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface VehiculetracteurRepository extends JpaRepository<Vehiculetracteur, Long>{

    Vehiculetracteur findByImmatriculation(String immatriculation);
}
