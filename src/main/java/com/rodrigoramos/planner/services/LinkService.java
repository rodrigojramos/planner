package com.rodrigoramos.planner.services;

import com.rodrigoramos.planner.dto.*;
import com.rodrigoramos.planner.entities.Activity;
import com.rodrigoramos.planner.entities.Link;
import com.rodrigoramos.planner.entities.Trip;
import com.rodrigoramos.planner.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public LinkResponse registerLink(LinkRequestPayload payload, Trip trip) {
        Link newLink = new Link(payload.title(), payload.url(), trip);

        linkRepository.save(newLink);

        return new LinkResponse(newLink.getId());
    }

    public List<LinkData> getAllLinksFromEvent(UUID tripId) {
        return linkRepository.findByTripId(tripId).stream().map(link -> new LinkData(link.getId(), link.getTitle(),
                link.getUrl())).toList();
    }
}
