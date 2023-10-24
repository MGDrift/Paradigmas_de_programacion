package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Subasta;
import com.paradigmas.subasta.repository.SubastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubastaServicelmpl implements SubastaService {

    @Autowired
    private SubastaRepository subastaRepository;

    public List<Subasta> getAllAuction() {
        return subastaRepository.findAll();
    }

    public Subasta getById(String id) {
        return subastaRepository.findById(id).orElse(new Subasta());
    }

    public Subasta createOrUpdateAuction(Subasta subasta) {
        return subastaRepository.save(subasta);
    }

    public void deleteAuction(String id) {
        subastaRepository.deleteById(id);
    }
}
