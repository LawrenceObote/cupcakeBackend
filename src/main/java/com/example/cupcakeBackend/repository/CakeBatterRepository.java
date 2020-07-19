package com.example.cupcakeBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cupcakeBackend.model.CakeBatter;

@Repository

public interface CakeBatterRepository extends JpaRepository<CakeBatter, Long> {

}