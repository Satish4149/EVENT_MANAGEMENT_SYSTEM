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

import com.EventManagementSystem.Entity.Organizer;
import com.EventManagementSystem.Service.OrganizerService;

@RestController
public class OrganizerController {
	
	@Autowired
    private OrganizerService organizerService;

    @PostMapping("/addOrganizer")
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        Organizer createdOrganizer = organizerService.createOrganizer(organizer);
        return ResponseEntity.ok(createdOrganizer);
    }

    @GetMapping("/getOrganizer/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateOrganizer/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        Organizer updatedOrganizer = organizerService.updateOrganizer(id, organizer);
        return updatedOrganizer != null ? ResponseEntity.ok(updatedOrganizer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteOrganizer/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }

}
