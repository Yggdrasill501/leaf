export interface Party {
  id: number;
  name: string;
  leader: string;
  ideology: string;
  headquarters: string;
}

const API_BASE_URL = 'http://localhost:8080/api/parties';

const partyService = {
  getAllParties: async (): Promise<Party[]> => {
    const response = await fetch(API_BASE_URL);
    return await response.json();
  },

  getPartyById: async (id: number): Promise<Party> => {
    const response = await fetch(`${API_BASE_URL}/${id}`);
    return await response.json();
  }
};

export default partyService;
