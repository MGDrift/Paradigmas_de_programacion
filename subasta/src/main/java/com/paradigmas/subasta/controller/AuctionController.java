package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Auction;
import com.paradigmas.subasta.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/list")
    public ResponseEntity<List<Auction>> getAllAuction() {
        var auctions = auctionService.getAllAuction();
        return ResponseEntity.ok(auctions);
    }

    @GetMapping
    public ResponseEntity<Auction> getById(@RequestParam("id") String id) {
        var auctions = auctionService.getById(id);
        return ResponseEntity.ok(auctions);
    }

    @PostMapping
    public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
        var auctionSaved = auctionService.createOrUpdateAuction(auction);
        return ResponseEntity.ok(auctionSaved);
    }

    @DeleteMapping
    public ResponseEntity deleteAuction(@RequestParam("id") String id) {
        auctionService.deleteAuction(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Auction> updateAuction(@RequestBody Auction auction) {
        var auctionSaved = auctionService.createOrUpdateAuction(auction);
        return ResponseEntity.ok(auctionSaved);
    }

}
