package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	Location findById(int id);
	List<Location> findAll();
	List<Location> findByCity(String city);
	List<Location> findByBlock(String block);
	List<Location> findByStreet(String street);
	List<Location> findByZipCode(String zipCode);
	List<Location> findByCoord1AndCoord2(double coord1, double coord2);
	
}
