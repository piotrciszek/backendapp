package com.backendapp.service;

import com.backendapp.model.Waypoint;
import com.backendapp.repository.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaypointServiceImpl implements WaypointService {

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointServiceImpl(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    @Override
    public List<Waypoint> getAllWaypoints() {
        return waypointRepository.findAll();
    }   

    @Override
    public List<Waypoint> searchWaypoints(String ident, String wtype) {
        if (ident != null && wtype != null) {
            return waypointRepository.findByIdentAndType(ident, wtype);
        } else if (ident != null && wtype == null) {
            return waypointRepository.findByIdent(ident);
        } else if (wtype != null && ident == null) {
            return waypointRepository.findByType(wtype);
        } else {
            return waypointRepository.findAll();
        }
    }

    @Override
    public Optional<Waypoint> getWaypointById(Long id) {
        return waypointRepository.findById(id);
    }
}
