package com.erkan.HouseService.repository;

import com.erkan.HouseService.model.House;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends MongoRepository<House, String> {
    List<House> findAllByName(String name);
    Optional<House> findByName(String name);

    Optional<House> findByPrice(Integer price);
}
