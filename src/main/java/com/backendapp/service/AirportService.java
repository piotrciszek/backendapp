package com.backendapp.service;

import com.backendapp.model.Airport;
import java.util.List;
import java.util.Optional;


public interface AirportService {

    List<Airport> getAllAirports();
    List<Airport> searchAirports(String icao, String name);
    Optional<Airport> getAirportById(Long id);
    
}
