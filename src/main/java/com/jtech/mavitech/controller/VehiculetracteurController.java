package com.jtech.mavitech.controller;

import com.jtech.mavitech.entity.Vehiculetracteur;
import com.jtech.mavitech.service.VehiculetracteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculetracteur")
public class VehiculetracteurController {

    @Autowired
    VehiculetracteurService vehiculetracteurService;

    @GetMapping("/read/{idvehicule}")
    public Optional<Vehiculetracteur> findById(@PathVariable(value = "idvehicule") Long idvehicule){
        return vehiculetracteurService.findById(idvehicule);
    }

    @GetMapping("/read-by-immatriculation/{immatriculation}")
    public Vehiculetracteur findByImmatriculation(@PathVariable(value = "immatriculation") String immatriculation){
        return vehiculetracteurService.findByImmatriculation(immatriculation);
    }

    @PostMapping("/save")
    public Vehiculetracteur save(@RequestBody Vehiculetracteur vehiculetracteur){
        return vehiculetracteurService.save(vehiculetracteur);
    }

    @PutMapping("/update/{id}")
    public Vehiculetracteur update(@PathVariable(value = "idvehicule") Long idvehicule, @RequestBody Vehiculetracteur vehiculetracteur){
        return vehiculetracteurService.update(idvehicule, vehiculetracteur);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("idvehicule") Long idvehicule){
        vehiculetracteurService.deleteById(idvehicule);
        return "Vehicule tracteur supprimé avec succès!!!";
    }
}
