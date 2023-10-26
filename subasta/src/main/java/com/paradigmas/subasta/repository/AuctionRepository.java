package com.paradigmas.subasta.repository;

import com.paradigmas.subasta.model.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuctionRepository extends MongoRepository<Auction, String> {

    List<Auction> findAllByCreatorDocument(String creatorDocument);
    List<Auction> findAllByBuyerDocument(String creatorDocument);

}
