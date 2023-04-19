package com.erkan.HouseService.service;


import com.erkan.HouseService.exception.HouseAlreadyExistsException;
import com.erkan.HouseService.exception.HouseNotFoundException;
import com.erkan.HouseService.model.House;
import com.erkan.HouseService.repository.HouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    public List<House> getHouses(String name) {
        if (name == null) {
            return houseRepository.findAll();
        } else {
            return houseRepository.findAllByName(name);
        }
    }

    public House createHouse(House newHouse) {

        Optional<House> houseByName = houseRepository.findByName(newHouse.getName());
        if (houseByName.isPresent()) {
            throw new HouseAlreadyExistsException("House already exists with name: " + newHouse.getName());
        }
        return houseRepository.save(newHouse);
    }


    public void deleteHouse(String id) {
        houseRepository.deleteById(id);
    }

    public House getHouseById(String id) {
        return houseRepository.findById(id)
                .orElseThrow(() -> new HouseNotFoundException("House not found with id: " + id));
    }


    public void updateHouse(String id, House newHouse) {
        House oldHouse = getHouseById(id);
        oldHouse.setName(newHouse.getName());
        houseRepository.save(oldHouse);
    }
}
