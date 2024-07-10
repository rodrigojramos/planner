package com.rodrigoramos.planner.repositories;

import com.rodrigoramos.planner.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<Link, UUID> {
}
