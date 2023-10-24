package com.paradigmas.subasta.repository;

import com.paradigmas.subasta.model.Subasta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubastaRepository extends MongoRepository<Subasta, String> {

}
