import { FC } from 'react';
import { useRouter } from 'next/router';
import PartyDetails from '../../components/PartyDetails';

const PartyPage: FC = () => {
  const router = useRouter();
  const { id } = router.query;

  return id ? <PartyDetails id={Number(id)} /> : <p>Loading...</p>;
};

export default PartyPage;
