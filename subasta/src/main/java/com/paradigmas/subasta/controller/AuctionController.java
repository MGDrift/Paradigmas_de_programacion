package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Auction;
import com.paradigmas.subasta.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/list")
    public ResponseEntity<List<Auction>> getAllAuction(@RequestParam(name = "creatorDocument", required = false) String creatorDocument,
                                                       @RequestParam(name = "buyerDocument", required = false) String buyerDocument) {
        var auctions = new ArrayList<Auction>();
        if (creatorDocument != null && !creatorDocument.isBlank()) {
            auctions = (ArrayList<Auction>) auctionService.getAllAuctionByCreatorDocument(creatorDocument);
        } else if (buyerDocument != null && !buyerDocument.isBlank()) {
            auctions = (ArrayList<Auction>) auctionService.getAllAuctionByBuyerDocument(buyerDocument);
        } else {
            auctions = (ArrayList<Auction>) auctionService.getAllAuction();
        }
        return ResponseEntity.ok(auctions);
    }

    @GetMapping("/change-buyer")
    public ResponseEntity changeBuyer(@RequestParam("id") String id,
                                      @RequestParam("buyerDocument") String buyerDocument) {
        try {
            auctionService.changeBuyer(id, buyerDocument);
            return ResponseEntity.ok().build();
        } catch (RuntimeException rte) {
            System.err.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
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
