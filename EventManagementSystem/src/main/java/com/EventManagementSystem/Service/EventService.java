package com.EventManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventManagementSystem.Entity.Event;
import com.EventManagementSystem.Entity.Organizer;
import com.EventManagementSystem.Entity.Venue;
import com.EventManagementSystem.Repository.EventRepository;

@Service
public class EventService {

	@Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        } else {
            return null;
        }
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByVenue(Venue venue) {
        return eventRepository.findByVenue(venue);
    }

    public List<Event> getEventsByOrganizer(Organizer organizer) {
        return eventRepository.findByOrganizer(organizer);
    }
}
