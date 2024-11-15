package com.parkpaku.parkpaku.controller;

import com.parkpaku.parkpaku.entity.ParkEntity;
import com.parkpaku.parkpaku.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ParkController {
    final private ParkService parkService;

    @Autowired
    ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

    @GetMapping(value = "/park/{id}", produces = "application/json")
    public ResponseEntity<ParkEntity> getPark(@PathVariable Long id) {
        ParkEntity parkEntity = parkService.findParkById(id);
        if(parkEntity != null) {
            return ResponseEntity.ok(parkEntity);
        } else {
            return ResponseEntity.status(NOT_FOUND).build();
        }
    }

}
