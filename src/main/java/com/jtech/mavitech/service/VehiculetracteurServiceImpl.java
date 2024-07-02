package com.jtech.mavitech.service;

import com.jtech.mavitech.entity.Vehiculetracteur;
import com.jtech.mavitech.repository.VehiculetracteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculetracteurServiceImpl implements VehiculetracteurService{

    @Autowired
    VehiculetracteurRepository vehiculetracteurRepository;

    @Override
    public Optional<Vehiculetracteur> findById(Long idvehicule) {
        return vehiculetracteurRepository.findById(idvehicule);
    }

    @Override
    public Vehiculetracteur findByImmatriculation(String immatriculation) {
        return vehiculetracteurRepository.findByImmatriculation(immatriculation);
    }

    @Override
    public List<Vehiculetracteur> findAll() {
        return vehiculetracteurRepository.findAll();
    }

    @Override
    public Vehiculetracteur save(Vehiculetracteur vehiculetrateur) {
        return vehiculetracteurRepository.save(vehiculetrateur);
    }

    @Override
    public Vehiculetracteur update(Long idvehicule, Vehiculetracteur vehiculetrateur) {
        Vehiculetracteur newVehiculetracteur = vehiculetracteurRepository.findById(idvehicule).orElseThrow(() -> new RuntimeException("Aucun véhicule trouvé"));

        newVehiculetracteur.setNumchassis(vehiculetrateur.getNumchassis());
        newVehiculetracteur.setImmatriculation(vehiculetrateur.getImmatriculation());
        newVehiculetracteur.setMarque(vehiculetrateur.getMarque());

        return vehiculetracteurRepository.save(newVehiculetracteur);
    }

    @Override
    public String deleteById(Long id) {
        vehiculetracteurRepository.deleteById(id);
        return "Vehicule tracteur supprimer avec succès!!";
    }
}
