package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Remorque;

import java.util.List;
import java.util.Optional;

public interface RemorqueService {

    Optional<Remorque> findById(Long idremorque);

    List<Remorque> findAll();

    Remorque save(Remorque remorque);

    Remorque update(Long idremorque, Remorque remorque);

    String deleteById(Long idremorque);
}
