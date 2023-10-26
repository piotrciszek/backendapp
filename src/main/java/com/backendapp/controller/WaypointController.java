package com.backendapp.controller;

import com.backendapp.model.Waypoint;
import com.backendapp.model.WaypointSearchRequest;
import com.backendapp.service.WaypointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/waypoint")
@CrossOrigin(origins = "http://localhost:3000")
public class WaypointController {

    private final WaypointService waypointService;

    @Autowired
    public WaypointController(WaypointService waypointService) {
        this.waypointService = waypointService;
    }

    @PostMapping("/search")
    public ResponseEntity<ServerResponse<List<Waypoint>>> searchWaypoints(@RequestBody WaypointSearchRequest searchParameters) {
        List<Waypoint> searchResults = waypointService.searchWaypoints(searchParameters.getIdent(), searchParameters.getWtype());
        ServerResponse<List<Waypoint>> response = new ServerResponse<>("success", "Data retrieved successfully", searchResults);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Waypoint> getWaypointById(@PathVariable Long id) {
        Optional<Waypoint> waypoint = waypointService.getWaypointById(id);
        return waypoint.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
