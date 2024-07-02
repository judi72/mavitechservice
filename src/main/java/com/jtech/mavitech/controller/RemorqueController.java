package com.jtech.mavitech.controller;

import com.jtech.mavitech.entity.Remorque;
import com.jtech.mavitech.service.RemorqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/remorque")
public class RemorqueController {

    @Autowired
    RemorqueService remorqueService;

    @GetMapping("/read/{id}")
    public Optional<Remorque> findById(@PathVariable(value = "idremorque") Long idremorque){
        return remorqueService.findById(idremorque);
    }

    @PostMapping("/save")
    public Remorque save(@RequestBody Remorque remorque){
        return remorqueService.save(remorque);
    }

    @PutMapping("/update/{id}")
    public Remorque update(@PathVariable(value = "idremorque") Long idremorque, @RequestBody Remorque remorque){
        return remorqueService.update(idremorque, remorque);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "idremorque") Long idremorque){
        remorqueService.deleteById(idremorque);

        return "Remorque supprimé avec succès!!!";
    }
}
