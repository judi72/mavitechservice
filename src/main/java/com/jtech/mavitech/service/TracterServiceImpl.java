package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Tracter;
import com.jtech.mavitech.entity.TracterPK;
import com.jtech.mavitech.repository.TracterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TracterServiceImpl implements TracterService{

    @Autowired
    TracterRepository tracterRepository;

    @Override
    public Optional<Tracter> findById(TracterPK tracterPK) {
        return tracterRepository.findById(tracterPK);
    }

    @Override
    public List<Tracter> findAll() {
        return tracterRepository.findAll();
    }

    @Override
    public Tracter save(Tracter tracter) {
        return tracterRepository.save(tracter);
    }

    @Override
    public Tracter update(TracterPK tracterPK, Tracter tracter) {
        Tracter newTracter = tracterRepository.findById(tracterPK).orElseThrow(() -> new RuntimeException("Aucune information trouvée!!"));
        newTracter.setTracterPK(tracter.getTracterPK());
        newTracter.setDateremorquage(tracter.getDateremorquage());
        newTracter.setDatefinremorquage(tracter.getDatefinremorquage());

        return tracterRepository.save(newTracter);
    }

    @Override
    public String delete(TracterPK tracterPK) {
        tracterRepository.deleteById(tracterPK);

        return "Information supprimée avec succès!!";
    }
}
