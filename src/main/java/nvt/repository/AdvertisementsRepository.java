package nvt.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Advertisement;
import nvt.beans.Agent;
import nvt.beans.RealEstate;

public interface AdvertisementsRepository extends JpaRepository<Advertisement, Integer> {

	Advertisement findById(int id);
	List<Advertisement> findAll();
	List<Advertisement> findByInappropriateTrue();
	List<Advertisement> findByInappropriateFalse();
	List<Advertisement> findByAgent(Agent agent);
	List<Advertisement> findByRealEstate(RealEstate realEstate);
	Page<Advertisement> findAll(Pageable page);


}
