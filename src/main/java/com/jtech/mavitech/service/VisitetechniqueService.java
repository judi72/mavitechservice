package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Visitetechnique;

import java.util.Optional;

public interface VisitetechniqueService {

    Optional<Visitetechnique> findById(Long idviste);

    Visitetechnique save(Visitetechnique visitetechnique);


    Visitetechnique update(Long id, Visitetechnique visitetechnique);

    String deleteById(Long idvisite);

}
