package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateType;

public interface RealEstateTypeRepository extends JpaRepository<RealEstateType, Integer> {

	RealEstateType findById(int id);
	List<RealEstateType> findAll();
	
}
