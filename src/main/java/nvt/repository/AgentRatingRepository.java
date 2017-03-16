package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Agent;
import nvt.beans.AgentRating;
import nvt.beans.User;

public interface AgentRatingRepository extends JpaRepository<AgentRating, Integer> {

	AgentRating findById(int id);
	List<AgentRating> findAll();
	List<AgentRating> findByRate(int rate);
	List<AgentRating> findByAgent(Agent agent);
	List<AgentRating> findByUser(User user);
	List<AgentRating> findByAgentAndRate(Agent agent, int rate);
	
}
