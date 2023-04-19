package com.erkan.HouseService.controller;


import com.erkan.HouseService.exception.HouseAlreadyExistsException;
import com.erkan.HouseService.exception.HouseNotFoundException;
import com.erkan.HouseService.model.House;
import com.erkan.HouseService.service.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/houses")
@AllArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping
    public ResponseEntity<List<House>> getHouses(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(houseService.getHouses(name), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getHouse(@PathVariable String id) {
        return new ResponseEntity<>(getHouseById(id), OK);
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House newHouse) {
        return new ResponseEntity<>(houseService.createHouse(newHouse), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> getHouse(@PathVariable String id, @RequestBody House newHouse) {
        houseService.updateHouse(id, newHouse);
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable String id) {
        houseService.deleteHouse(id);
        return new ResponseEntity<>(OK);
    }

    private House getHouseById(String id) {
        return houseService.getHouseById(id);
    }


    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<String> handleIlNotFoundException(HouseNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), NOT_FOUND);
    }

    @ExceptionHandler(HouseAlreadyExistsException.class)
    public ResponseEntity<String> handleIlIlAlreadyExistsException(HouseAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), CONFLICT);
    }


}
