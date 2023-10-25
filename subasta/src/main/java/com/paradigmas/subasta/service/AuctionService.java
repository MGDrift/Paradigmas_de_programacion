package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Auction;

import java.util.List;

public interface AuctionService {

    List<Auction> getAllAuction();

    Auction getById(String id);
    Auction createOrUpdateAuction(Auction emp);

    void deleteAuction(String id);
}
