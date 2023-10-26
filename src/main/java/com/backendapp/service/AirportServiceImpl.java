package com.backendapp.service;

import com.backendapp.model.Airport;
import com.backendapp.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }   

    @Override
    public List<Airport> searchAirports(String icao, String name) {
        if (icao != null && name != null) {
            return airportRepository.findByIcaoAndName(icao, name);
        } else if (icao != null && name == null) {
            return airportRepository.findByIcao(icao);
        } else if (name != null && icao == null) {
            return airportRepository.findByName(name);
        } else {
            return airportRepository.findAll();
        }
    }

    @Override
    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }
}
