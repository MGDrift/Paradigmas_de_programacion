package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Subasta;

import java.util.List;

public interface SubastaService {

    List<Subasta> getAllAuction();

    Subasta getById(String id);
    Subasta createOrUpdateAuction(Subasta emp);

    void deleteAuction(String id);
}
