package com.backendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendapp.model.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("SELECT a FROM Airport a WHERE LOWER(a.icao) LIKE LOWER(CONCAT(:icaoPrefix, '%')) AND LOWER(a.name) LIKE LOWER(CONCAT(:namePrefix, '%'))")
    List<Airport> findByIcaoAndName(String icaoPrefix, String namePrefix);

    @Query("SELECT a FROM Airport a WHERE LOWER(a.icao) LIKE LOWER(CONCAT(:icaoPrefix, '%'))")
    List<Airport> findByIcao(String icaoPrefix);

    @Query("SELECT a FROM Airport a WHERE LOWER(a.name) LIKE LOWER(CONCAT(:icaoPrefix, '%'))")
    List<Airport> findByName(String icaoPrefix);
}
