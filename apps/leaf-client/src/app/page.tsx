import { FC } from 'react';
import PartyList from '../components/PartyList';

const Home: FC = () => {
  return (
    <div className="container mx-auto">
      <h1 className="text-2xl font-bold">Political Parties</h1>
      <PartyList />
    </div>
  );
};

export default Home;
