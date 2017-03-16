package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Agent;
import nvt.repository.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository agentRepository;
	
	
    public Agent findById(int id) {
    	return agentRepository.findOne(id);
    }
    
    public List<Agent> findAll() {
    	return agentRepository.findAll();
    }
    
    public Page<Agent> findAll(Pageable page) {
    	return agentRepository.findAll(page);
    }
    
    public Agent save(Agent agent) {
    	return agentRepository.save(agent);
    }
    
    public Agent saveAndFlush(Agent agent) {
    	return agentRepository.saveAndFlush(agent);
    }
    
    public void removeById(int id) {
    	agentRepository.delete(id);
    }
    
    public void remove(Agent agent) {
    	agentRepository.delete(agent);
    }
    
    
}
