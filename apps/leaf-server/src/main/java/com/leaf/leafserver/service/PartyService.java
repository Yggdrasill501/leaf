package com.leaf.leafserver.service;

import com.leaf.leafserver.model.Party;
import com.leaf.leafserver.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    // Retrieve all parties
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    // Retrieve a single party by ID
    public Party getPartyById(Long id) {
        Optional<Party> party = partyRepository.findById(id);
        return party.orElse(null);
    }

    // Save a new or updated party
    public Party saveParty(Party party) {
        return partyRepository.save(party);
    }

    // Delete a party by ID
    public void deleteParty(Long id) {
        partyRepository.deleteById(id);
    }
}
