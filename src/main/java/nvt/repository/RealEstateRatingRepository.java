package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateRating;

public interface RealEstateRatingRepository extends JpaRepository<RealEstateRating, Integer> {

	RealEstateRating findById(int id);
	List<RealEstateRating> findAll();

}
