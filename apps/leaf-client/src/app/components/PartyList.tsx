import { FC, useEffect, useState } from 'react';
import Link from 'next/link';
import partyService, { Party } from '../services/partyService';

const PartyList: FC = () => {
  const [parties, setParties] = useState<Party[]>([]);

  useEffect(() => {
    partyService.getAllParties().then(data => setParties(data));
  }, []);

  return (
    <ul>
      {parties.map((party) => (
        <li key={party.id}>
          <Link href={`/parties/${party.id}`}>
            {party.name}
          </Link>
        </li>
      ))}
    </ul>
  );
};

export default PartyList;
