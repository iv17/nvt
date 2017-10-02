package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.AgentRating;

public interface AgentRatingRepository extends JpaRepository<AgentRating, Integer> {

	AgentRating findById(int id);
	List<AgentRating> findAll();
	
}
