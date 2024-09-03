package com.leaf.leafserver.controller;

import com.leaf.leafserver.model.Party;
import com.leaf.leafserver.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    // Get all parties
    @GetMapping
    public List<Party> getAllParties() {
        return partyService.getAllParties();
    }

    // Get a single party by ID
    @GetMapping("/{id}")
    public Party getPartyById(@PathVariable Long id) {
        return partyService.getPartyById(id);
    }

    // Create a new party
    @PostMapping
    public Party createParty(@RequestBody Party party) {
        return partyService.saveParty(party);
    }

    // Update an existing party by ID
    @PutMapping("/{id}")
    public Party updateParty(@PathVariable Long id, @RequestBody Party partyDetails) {
        Party existingParty = partyService.getPartyById(id);
        if (existingParty != null) {
            existingParty.setName(partyDetails.getName());
            existingParty.setLeader(partyDetails.getLeader());
            existingParty.setIdeology(partyDetails.getIdeology());
            existingParty.setHeadquarters(partyDetails.getHeadquarters());
            return partyService.saveParty(existingParty);
        } else {
            return null; // Or throw an exception, e.g., ResourceNotFoundException
        }
    }

    // Delete a party by ID
    @DeleteMapping("/{id}")
    public void deleteParty(@PathVariable Long id) {
        partyService.deleteParty(id);
    }
}
