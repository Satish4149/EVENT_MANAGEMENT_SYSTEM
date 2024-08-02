package com.EventManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EventManagementSystem.Entity.Event;
import com.EventManagementSystem.Entity.Organizer;
import com.EventManagementSystem.Entity.Venue;

public interface EventRepository extends JpaRepository<Event, Long>{

	List<Event> findByVenue(Venue venue);
	
    List<Event> findByOrganizer(Organizer organizer);
}
