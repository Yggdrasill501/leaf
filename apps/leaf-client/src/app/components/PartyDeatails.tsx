import { FC, useEffect, useState } from 'react';
import partyService, { Party } from '../services/partyService';

interface PartyDetailsProps {
  id: number;
}

const PartyDetails: FC<PartyDetailsProps> = ({ id }) => {
  const [party, setParty] = useState<Party | null>(null);

  useEffect(() => {
    partyService.getPartyById(id).then(data => setParty(data));
  }, [id]);

  if (!party) return <p>Loading...</p>;

  return (
    <div>
      <h2 className="text-xl font-bold">{party.name}</h2>
      <p>Leader: {party.leader}</p>
      <p>Ideology: {party.ideology}</p>
      <p>Headquarters: {party.headquarters}</p>
    </div>
  );
};

export default PartyDetails;
