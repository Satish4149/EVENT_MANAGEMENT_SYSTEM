package com.EventManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EventManagementSystem.Entity.Event;
import com.EventManagementSystem.Entity.Organizer;
import com.EventManagementSystem.Entity.Venue;
import com.EventManagementSystem.Service.EventService;

@RestController
public class EventController {
	
	@Autowired
    private EventService eventService;

    @PostMapping("/addEvent")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    @GetMapping("/getAllEvents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/getEvent/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/updateEvent/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(id, event);
        return updatedEvent != null ? ResponseEntity.ok(updatedEvent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getEventbyVenue/{venueId}")
    public List<Event> getEventsByVenue(@PathVariable Long venueId) {
        Venue venue = new Venue();
        venue.setId(venueId);
        return eventService.getEventsByVenue(venue);
    }

    @GetMapping("/getEventByOrg/{organizerId}")
    public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);
        return eventService.getEventsByOrganizer(organizer);
    }

}
