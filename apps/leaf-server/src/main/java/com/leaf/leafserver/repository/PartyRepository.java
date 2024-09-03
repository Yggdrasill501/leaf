@Autowired
private PartyRepository partyRepository;

public List<Party> getAllParties() {
    return partyRepository.findAll();
}

public Party getPartyById(Long id) {
    return partyRepository.findById(id).orElse(null);
}

public Party saveParty(Party party) {
    return partyRepository.save(party);
}

public void deleteParty(Long id) {
    partyRepository.deleteById(id);
}
