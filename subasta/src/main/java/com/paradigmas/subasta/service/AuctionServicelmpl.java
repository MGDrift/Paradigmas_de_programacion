package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Auction;
import com.paradigmas.subasta.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServicelmpl implements AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public List<Auction> getAllAuction() {
        return auctionRepository.findAll();
    }

    public Auction getById(String id) {
        return auctionRepository.findById(id).orElse(new Auction());
    }

    public Auction createOrUpdateAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public void deleteAuction(String id) {
        auctionRepository.deleteById(id);
    }
}
