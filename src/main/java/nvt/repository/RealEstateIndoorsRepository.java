package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateIndoors;

public interface RealEstateIndoorsRepository  extends JpaRepository<RealEstateIndoors, Integer>{

	RealEstateIndoors findById(int id);
}
