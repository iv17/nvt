package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.ApartmentType;

public interface ApartmentTypeRepository extends JpaRepository<ApartmentType, Integer> {

	ApartmentType findById(int id);
	List<ApartmentType> findAll();
	
}
