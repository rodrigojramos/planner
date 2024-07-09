package com.rodrigoramos.planner.repositories;

import com.rodrigoramos.planner.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, UUID> {
}
