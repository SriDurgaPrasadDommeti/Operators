package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Calculator;

public interface OperationRepository extends JpaRepository<Calculator, Long>{

}
