package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.WorkingTime;

public interface WorkingTimeRepository extends JpaRepository<WorkingTime, Integer> {

	WorkingTime findById(int id);
	
}
