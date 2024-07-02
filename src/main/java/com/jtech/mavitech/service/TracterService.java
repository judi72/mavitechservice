package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Tracter;
import com.jtech.mavitech.entity.TracterPK;

import java.util.List;
import java.util.Optional;

public interface TracterService {

    Optional<Tracter> findById(TracterPK tracterPK);

    List<Tracter> findAll();

    Tracter save(Tracter tracter);

    Tracter update(TracterPK tracterPK, Tracter tracter);

    String delete(TracterPK tracterPK);
}
