package com.EventManagementSystem.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EventManagementSystem.Entity.Organizer;
import com.EventManagementSystem.Repository.OrganizerRepository;

@Service
public class OrganizerService {
	
	@Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer updateOrganizer(Long id, Organizer updatedOrganizer) {
        if (organizerRepository.existsById(id)) {
            updatedOrganizer.setId(id);
            return organizerRepository.save(updatedOrganizer);
        } else {
            return null;
        }
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }

}
