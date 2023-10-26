package com.backendapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendapp.model.Waypoint;

import java.util.List;

@Repository
public interface WaypointRepository extends JpaRepository<Waypoint, Long> {

    @Query("SELECT w FROM Waypoint w WHERE LOWER(w.ident) LIKE LOWER(CONCAT(:identPrefix, '%')) AND LOWER(w.wtype) LIKE LOWER(CONCAT(:wtypePrefix, '%'))")
    List<Waypoint> findByIdentAndType(String identPrefix, String wtypePrefix);

    @Query("SELECT w FROM Waypoint w WHERE LOWER(w.ident) LIKE LOWER(CONCAT(:identPrefix, '%'))")
    List<Waypoint> findByIdent(String identPrefix);

    @Query("SELECT w FROM Waypoint w WHERE LOWER(w.wtype) LIKE LOWER(CONCAT(:wtypePrefix, '%'))")
    List<Waypoint> findByType(String wtypePrefix);
}
