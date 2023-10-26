package com.paradigmas.subasta.service;

import com.paradigmas.subasta.model.Auction;

import java.util.List;

public interface AuctionService {

    List<Auction> getAllAuction();
    List<Auction> getAllAuctionByCreatorDocument(String creatorDocument);
    List<Auction> getAllAuctionByBuyerDocument(String buyerDocument);

    Auction getById(String id);
    Auction createOrUpdateAuction(Auction emp);
    void changeBuyer(String id, String buyerDocument);

    void deleteAuction(String id);
}
