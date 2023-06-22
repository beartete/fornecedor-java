package com.fatec.fornecedor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.fornecedor.entities.Supplier;

public interface SupplierRepository extends JpaRepository <Supplier, Integer>{

    Object findById(int id);

    List<Supplier> findAll();
    
}