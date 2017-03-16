package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
