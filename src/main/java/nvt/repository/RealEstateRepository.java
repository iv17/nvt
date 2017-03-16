package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Location;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateType;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer> {

	RealEstate findById(int id);
	List<RealEstate> findAll();
	List<RealEstate> findByLocation(Location location);
	List<RealEstate> findByRealEstateType(RealEstateType type); 
	List<RealEstate> findByPriceBetween(double p1, double p2);
	List<RealEstate> findBySurfaceBetween(double s1, double s2);
	
}
