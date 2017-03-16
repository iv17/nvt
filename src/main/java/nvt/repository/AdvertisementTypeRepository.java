package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.AdvertisementType;

public interface AdvertisementTypeRepository extends JpaRepository<AdvertisementType, Integer> {

	AdvertisementType findById(int id);
	
}
