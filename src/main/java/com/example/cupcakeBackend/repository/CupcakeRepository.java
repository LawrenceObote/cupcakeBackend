package com.example.cupcakeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cupcakeBackend.model.Cupcake;

@Repository

public interface CupcakeRepository extends JpaRepository<Cupcake, Long> {

}
