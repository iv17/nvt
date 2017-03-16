package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.HeatingType;

public interface HeatingTypeRepository extends JpaRepository<HeatingType, Integer> {

	HeatingType findById(int id);
	List<HeatingType> findAll();
}
