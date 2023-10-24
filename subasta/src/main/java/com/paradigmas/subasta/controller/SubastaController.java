package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Subasta;
import com.paradigmas.subasta.service.SubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subasta")
public class SubastaController {

    @Autowired
    private SubastaService subastaService;

    @GetMapping("/list")
    public ResponseEntity<List<Subasta>> getAllAuction() {
        var subastas = subastaService.getAllAuction();
        return ResponseEntity.ok(subastas);
    }

    @GetMapping
    public ResponseEntity<Subasta> getById(@RequestParam("id") String id) {
        var subastas = subastaService.getById(id);
        return ResponseEntity.ok(subastas);
    }

    @PostMapping
    public ResponseEntity<Subasta> createAuction(@RequestBody Subasta subasta) {
        var subastaSaved = subastaService.createOrUpdateAuction(subasta);
        return ResponseEntity.ok(subastaSaved);
    }

    @DeleteMapping
    public ResponseEntity deleteAuction(@RequestParam("id") String id) {
        subastaService.deleteAuction(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Subasta> updateAuction(@RequestBody Subasta subasta) {
        var subastaSaved = subastaService.createOrUpdateAuction(subasta);
        return ResponseEntity.ok(subastaSaved);
    }

}
