package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstate;
import nvt.beans.RealEstateRating;
import nvt.beans.User;

public interface RealEstateRatingRepository extends JpaRepository<RealEstateRating, Integer> {

	RealEstateRating findById(int id);
	List<RealEstateRating> findAll();
	List<RealEstateRating> findByRealEstate(RealEstate realEstate);
	List<RealEstateRating> findByUser(User user);
	List<RealEstateRating> findByRealEstateAndRate(RealEstate realEstate, int rate);
	
}
