package com.backendapp.controller;

import com.backendapp.model.Airport;
import com.backendapp.model.SearchRequest;
import com.backendapp.service.AirportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/airport")
@CrossOrigin(origins = "http://localhost:3000")
public class AirportController {

    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/search")
    public ResponseEntity<ServerResponse<List<Airport>>> searchAirports(@RequestBody SearchRequest searchParameters) {
        List<Airport> searchResults = airportService.searchAirports(searchParameters.getIcao(), searchParameters.getName());
        ServerResponse<List<Airport>> response = new ServerResponse<>("success", "Data retrieved successfully", searchResults);
        return ResponseEntity.ok(response);
    }
}
