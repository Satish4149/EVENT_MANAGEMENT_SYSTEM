package com.EventManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EventManagementSystem.Entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long>{

}
