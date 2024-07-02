package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Vehiculetracteur;

import java.util.List;
import java.util.Optional;

public interface VehiculetracteurService {

    Optional<Vehiculetracteur> findById(Long idvehicule);

    Vehiculetracteur findByImmatriculation(String immatriculation);

    List<Vehiculetracteur> findAll();

    Vehiculetracteur save(Vehiculetracteur vehiculetrateur);

    Vehiculetracteur update(Long idvehicule, Vehiculetracteur vehiculetrateur);

    String deleteById(Long id);
}
