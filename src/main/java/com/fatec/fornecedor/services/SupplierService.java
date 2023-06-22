package com.fatec.fornecedor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fornecedor.entities.Supplier;
import com.fatec.fornecedor.repositories.SupplierRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier getSupplierById(int id){
        return supplierRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrado!")
        );
    }

    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    }

    public void deleteById(int id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
    }

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void update(int id, Supplier supplier) {
        getSupplierById(id);
        supplierRepository.save(supplier);
    }
}