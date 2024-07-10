package com.rodrigoramos.planner.services;

import com.rodrigoramos.planner.dto.ActivityRequestPayload;
import com.rodrigoramos.planner.dto.ActivityResponse;
import com.rodrigoramos.planner.entities.Activity;
import com.rodrigoramos.planner.entities.Trip;
import com.rodrigoramos.planner.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        activityRepository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }

}
