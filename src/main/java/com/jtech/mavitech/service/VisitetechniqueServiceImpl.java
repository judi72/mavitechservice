package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Visitetechnique;
import com.jtech.mavitech.repository.VisitetechniqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitetechniqueServiceImpl implements VisitetechniqueService{

    @Autowired
    VisitetechniqueRepository visitetechniqueRepository;

    @Override
    public Optional<Visitetechnique> findById(Long idviste) {
        return visitetechniqueRepository.findById(idviste);
    }

    @Override
    public Visitetechnique save(Visitetechnique visitetechnique) {
        return visitetechniqueRepository.save(visitetechnique);
    }

    @Override
    public Visitetechnique update(Long idvisite, Visitetechnique visitetechnique) {
        Visitetechnique newVisitetechnique = visitetechniqueRepository.findById(idvisite).orElseThrow(() -> new RuntimeException("Visite technique non trouvé"));
        newVisitetechnique.setIdvehicule(visitetechnique.getIdvehicule());
        newVisitetechnique.setIdvisite(visitetechnique.getIdvisite());
        newVisitetechnique.setDatevalidite(visitetechnique.getDatevalidite());
        newVisitetechnique.setDatevisite(visitetechnique.getDatevisite());
        newVisitetechnique.setObservation(visitetechnique.getObservation());

        return visitetechniqueRepository.save(newVisitetechnique);
    }

    @Override
    public String deleteById(Long idvisite) {
        visitetechniqueRepository.deleteById(idvisite);

        return "Visite technique supprimée avec succès!!!";
    }
}
