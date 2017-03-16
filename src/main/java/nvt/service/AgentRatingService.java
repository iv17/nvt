package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.AgentRating;
import nvt.repository.AgentRatingRepository;

@Service
public class AgentRatingService {

	@Autowired
	AgentRatingRepository agentRatingRepository;
	
	
	public AgentRating findById(int id) {
		return agentRatingRepository.findById(id);
	}
	
	public List<AgentRating> findAll() {
		return agentRatingRepository.findAll();
	}
	
	public Page<AgentRating> findAll(Pageable page) {
		return agentRatingRepository.findAll(page);	
	}
	
	public AgentRating save(AgentRating agentRating) {
		return agentRatingRepository.save(agentRating);
	}
	
	public AgentRating saveAndFlush(AgentRating agentRating) {
		return agentRatingRepository.saveAndFlush(agentRating);
	}
	
	public void removeById(int id) {
		agentRatingRepository.delete(id);
	}
	
	public void remove(AgentRating agentRating) {
		agentRatingRepository.delete(agentRating);
	}
}
