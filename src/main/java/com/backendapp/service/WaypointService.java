package com.backendapp.service;

import com.backendapp.model.Waypoint;
import java.util.List;
import java.util.Optional;


public interface WaypointService {

    List<Waypoint> getAllWaypoints();
    List<Waypoint> searchWaypoints(String ident, String wtype);
    Optional<Waypoint> getWaypointById(Long id);
    
}
