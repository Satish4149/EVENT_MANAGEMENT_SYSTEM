package com.EventManagementSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventManagementSystem.Entity.Venue;
import com.EventManagementSystem.Repository.VenueRepository;

@Service
public class VenueService {
	
	@Autowired
    private VenueRepository venueRepository;

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Venue updateVenue(Long id, Venue updatedVenue) {
        if (venueRepository.existsById(id)) {
            updatedVenue.setId(id);
            return venueRepository.save(updatedVenue);
        } else {
            return null;
        }
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }

}
