package com.rodrigoramos.planner.services;

import com.rodrigoramos.planner.dto.ActivityData;
import com.rodrigoramos.planner.dto.ActivityRequestPayload;
import com.rodrigoramos.planner.dto.ActivityResponse;
import com.rodrigoramos.planner.entities.Activity;
import com.rodrigoramos.planner.entities.Trip;
import com.rodrigoramos.planner.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newActivity = new Activity(payload.title(), payload.occurs_at(), trip);

        activityRepository.save(newActivity);

        return new ActivityResponse(newActivity.getId());
    }

    public List<ActivityData> getAllActivitiesFromEvent(UUID tripId) {
        return activityRepository.findByTripId(tripId).stream().map(activity -> new ActivityData(activity.getId(),
                activity.getTitle(), activity.getOccursAt())).toList();
    }
}
