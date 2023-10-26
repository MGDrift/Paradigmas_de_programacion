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

    @Override
    public List<Auction> getAllAuctionByCreatorDocument(String creatorDocument) {
        return auctionRepository.findAllByCreatorDocument(creatorDocument);
    }

    @Override
    public List<Auction> getAllAuctionByBuyerDocument(String buyerDocument) {
        return auctionRepository.findAllByBuyerDocument(buyerDocument);
    }

    public Auction getById(String id) {
        return auctionRepository.findById(id).orElse(new Auction());
    }

    public Auction createOrUpdateAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public void changeBuyer(String id, String buyerDocument) {
        var auctionOpt = auctionRepository.findById(id);
        if (auctionOpt.isEmpty()) {
            throw new RuntimeException(String.format("La subasta con el id %s no existe.", id));
        } else {
            var auction = auctionOpt.get();
            auction.setBuyerDocument(buyerDocument);
            auctionRepository.save(auction);
        }
    }

    public void deleteAuction(String id) {
        auctionRepository.deleteById(id);
    }
}
