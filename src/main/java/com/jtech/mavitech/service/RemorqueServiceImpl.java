package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Remorque;
import com.jtech.mavitech.repository.RemorqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemorqueServiceImpl implements RemorqueService{

    @Autowired
    RemorqueRepository remorqueRepository;

    @Override
    public Optional<Remorque> findById(Long idremorque) {
        return remorqueRepository.findById(idremorque);
    }

    @Override
    public List<Remorque> findAll() {
        return remorqueRepository.findAll();
    }

    @Override
    public Remorque save(Remorque remorque) {
        return remorqueRepository.save(remorque);
    }

    @Override
    public Remorque update(Long idremorque, Remorque remorque) {
        Remorque newRemorque = remorqueRepository.findById(idremorque).orElseThrow(() -> new RuntimeException("Remorque non trouvé!!"));
        newRemorque.setImmatriculationrem(remorque.getImmatriculationrem());
        newRemorque.setNbreroue(remorque.getNbreroue());

        return remorqueRepository.save(remorque);
    }

    @Override
    public String deleteById(Long idremorque) {
        remorqueRepository.deleteById(idremorque);
        return "Remorque supprimé avec succès!!!";
    }
}
