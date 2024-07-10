package com.rodrigoramos.planner.services;

import com.rodrigoramos.planner.dto.ParticipantCreateResponse;
import com.rodrigoramos.planner.dto.ParticipantData;
import com.rodrigoramos.planner.entities.Participant;
import com.rodrigoramos.planner.entities.Trip;
import com.rodrigoramos.planner.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip){
       List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();

       participantRepository.saveAll(participants);
       System.out.println(participants.get(0).getId());
    }

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip) {
        Participant newParticipant = new Participant(email, trip);
        participantRepository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId){}

    public void triggerConfirmationEmailToParticipant(String email){}

    public List<ParticipantData> getAllParticipantsFromEvent(UUID tripId) {
        return participantRepository.findByTripId(tripId).stream().map(participant -> new ParticipantData(participant.getId(),
                participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }
}
