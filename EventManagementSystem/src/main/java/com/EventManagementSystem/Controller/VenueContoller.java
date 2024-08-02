package com.EventManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EventManagementSystem.Entity.Venue;
import com.EventManagementSystem.Service.VenueService;

@RestController
public class VenueContoller {
	
	@Autowired
    private VenueService venueService;

    @PostMapping("/createVenue")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        Venue createdVenue = venueService.createVenue(venue);
        return ResponseEntity.ok(createdVenue);
    }

    @GetMapping("getVenue/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("updateVenue/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long id, @RequestBody Venue venue) {
        Venue updatedVenue = venueService.updateVenue(id, venue);
        return updatedVenue != null ? ResponseEntity.ok(updatedVenue) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("deleteVenue/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.noContent().build();
    }

}
