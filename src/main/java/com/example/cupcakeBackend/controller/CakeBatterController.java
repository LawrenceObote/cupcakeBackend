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
import com.example.cupcakeBackend.model.CakeBatter;
import com.example.cupcakeBackend.repository.CakeBatterRepository;

@RestController
@RequestMapping("/cupcakeShop/v1")

public class CakeBatterController {

    @Autowired
    private CakeBatterRepository cakeBatterRepository;



    //get all cupcakes

    @GetMapping("/CakeBatters")
    public List<CakeBatter> getAllCakeBatters(Model model){
        return cakeBatterRepository.findAll();
    }
    //get all CakeBatters by id

    @GetMapping("/CakeBatters/{id}")
    public ResponseEntity<CakeBatter> getCakeBatterById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CakeBatter cakeBatter = cakeBatterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("CakeBatter not found for this id ::" + id ));
        return ResponseEntity.ok().body(cakeBatter);
    }
    //save employee

    @PostMapping("/CakeBatters")
    public CakeBatter createCakeBatter(@Valid @RequestBody CakeBatter cakeBatter) {
        return cakeBatterRepository.save(cakeBatter);
    }

    //Update CakeBatter

    @PutMapping("/CakeBatters/{id}")
    public ResponseEntity<CakeBatter> updateCakeBatterById(@PathVariable(value = "id") Long id, @Valid @RequestBody CakeBatter cakeBatterDetails)
            throws ResourceNotFoundException {
        CakeBatter cakeBatter = cakeBatterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cake Batter not found for this id :: " + id));

        cakeBatter.setCakeBatterName(cakeBatterDetails.getCakeBatterName());
        cakeBatter.setPrice(cakeBatterDetails.getPrice());


        final CakeBatter updatedCakeBatter = cakeBatterRepository.save(cakeBatter);

        return ResponseEntity.ok(updatedCakeBatter);
    }

    @DeleteMapping("/CakeBatters/{id}")
    public Map<String, Boolean> deletedCakeBatter(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CakeBatter cakeBatter = cakeBatterRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cake Batter not found for this id :: " + id));


        cakeBatterRepository.delete(cakeBatter);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted Cake Batter", Boolean.TRUE);

        return response;
    }
}
