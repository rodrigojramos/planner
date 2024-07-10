package com.rodrigoramos.planner.repositories;

import com.rodrigoramos.planner.entities.Activities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActivitiesRepository extends JpaRepository<Activities, UUID> {
}
