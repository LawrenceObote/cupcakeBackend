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
import com.example.cupcakeBackend.model.Cupcake;
import com.example.cupcakeBackend.repository.CupcakeRepository;

@RestController
@RequestMapping("/cupcakeShop/v1")

public class CupcakeController {

    @Autowired
    private CupcakeRepository cupcakeRepository;


    //get all cupcakes

    @GetMapping("/cupcakes")
    public List<Cupcake> getAllCupcakes(Model model){
        return cupcakeRepository.findAll();
    }
    //get all cupcakes by id

    @GetMapping("/cupcakes/{id}")
    public ResponseEntity<Cupcake> getCupcakeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Cupcake cupcake = cupcakeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cupcake not found for this id ::" + id ));
        return ResponseEntity.ok().body(cupcake);
    }
    //save employee

    @PostMapping("/cupcakes")
    public Cupcake createCupcake(@Valid @RequestBody Cupcake cupcake) {
        return cupcakeRepository.save(cupcake);
    }

    //Update Employee

    @PutMapping("/cupcakes/{id}")
    public ResponseEntity<Cupcake> updateCupcakeById(@PathVariable(value = "id") Long id, @Valid @RequestBody Cupcake cupcakeDetails)
            throws ResourceNotFoundException {
        Cupcake cupcake = cupcakeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cupcake not found for this id :: " + id));

        cupcake.setName(cupcakeDetails.getName());
        cupcake.setPrice(cupcakeDetails.getPrice());
        cupcake.setImageURL(cupcakeDetails.getImageURL());



        final Cupcake updatedCupcake = cupcakeRepository.save(cupcake);

        return ResponseEntity.ok(updatedCupcake);
    }

    @DeleteMapping("/cupcakes/{id}")
    public Map<String, Boolean> deletedCupcake(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Cupcake cupcake = cupcakeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cupcake not found for this id :: " + id));


        cupcakeRepository.delete(cupcake);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted cupcake", Boolean.TRUE);

        return response;
    }
}