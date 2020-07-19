package com.example.cupcakeBackend.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cupcakeBackend.exception.ResourceNotFoundException;
import com.example.cupcakeBackend.model.Frosting;
import com.example.cupcakeBackend.repository.FrostingRepository;

@RestController
@RequestMapping("/cupcakeShop/v1")

public class FrostingController {

    @Autowired
    private FrostingRepository frostingRepository;


    //get all frosting

    @GetMapping("/frosting")
    public List<Frosting> getAllFrosting(Model model){
        return frostingRepository.findAll();
    }
    //get all frosting by id

    @GetMapping("/frosting/{id}")
    public ResponseEntity<Frosting> getFrostingById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Frosting frosting = frostingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Frosting not found for this id ::" + id ));
        return ResponseEntity.ok().body(frosting);
    }
    //save frosting

    @PostMapping("/frosting")
    public Frosting createFrosting(@Valid @RequestBody Frosting frosting) {
        return frostingRepository.save(frosting);
    }

    //Update Employee

    @PutMapping("/frosting/{id}")
    public ResponseEntity<Frosting> updateFrostingById(@PathVariable(value = "id") Long id, @Valid @RequestBody Frosting frostingDetails)
            throws ResourceNotFoundException {
        Frosting frosting = frostingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Frosting not found for this id :: " + id));

        frosting.setFrostingName(frostingDetails.getFrostingName());
        frosting.setPrice(frostingDetails.getPrice());
        frosting.setImageURL(frostingDetails.getImageURL());



        final Frosting updatedFrosting = frostingRepository.save(frosting);

        return ResponseEntity.ok(updatedFrosting);
    }

    @DeleteMapping("/frostings/{id}")
    public Map<String, Boolean> deletedFrosting(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Frosting frosting = frostingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Frosting not found for this id :: " + id));


        frostingRepository.delete(frosting);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted frosting", Boolean.TRUE);

        return response;
    }
}

