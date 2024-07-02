package com.jtech.mavitech.controller;

import com.jtech.mavitech.entity.Visitetechnique;
import com.jtech.mavitech.service.VisitetechniqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/visite-technique")
public class VisitetechniqueController {

    @Autowired
    VisitetechniqueService visitetechniqueService;

    @GetMapping("/read/{idvisite}")
    public Optional<Visitetechnique> findById(@PathVariable(value = "idvisite") Long idvisite){
        return visitetechniqueService.findById(idvisite);
    }

    @PostMapping("/save")
    public Visitetechnique save(@RequestBody Visitetechnique visitetechnique){
        return visitetechniqueService.save(visitetechnique);
    }

    @PutMapping("/update/{idvisite}")
    public Visitetechnique update(@PathVariable(value = "idvisite") Long idvisite, @RequestBody Visitetechnique visitetechnique){
        return visitetechniqueService.update(idvisite, visitetechnique);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "idvisite") Long idvisite){
        visitetechniqueService.deleteById(idvisite);

        return "Visite technique supprimée avec succès!!";
    }
}
