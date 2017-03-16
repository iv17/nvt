package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateOutdoors;

public interface RealEstateOutdoorsRepository extends JpaRepository<RealEstateOutdoors, Integer> {

	RealEstateOutdoors findById(int id);
	
}
