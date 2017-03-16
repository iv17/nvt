package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateRating;
import nvt.repository.RealEstateRatingRepository;

@Service
public class RealEstateRatingService {

	@Autowired
	RealEstateRatingRepository realEstateRatingRepository;
	
	
	public RealEstateRating findById(int id) {
		return realEstateRatingRepository.findById(id);
	}
	
	public List<RealEstateRating> findAll() {
		return realEstateRatingRepository.findAll();
	}
	
	public Page<RealEstateRating> findAll(Pageable page) {
		return realEstateRatingRepository.findAll(page);
	}
	
	public RealEstateRating save(RealEstateRating realEstateRating) {
		return realEstateRatingRepository.save(realEstateRating);
	}
	
	public RealEstateRating saveAndFlush(RealEstateRating realEstateRating) {
		return realEstateRatingRepository.saveAndFlush(realEstateRating);
	}
	
	public void removeById(int id) {
		realEstateRatingRepository.delete(id);
	}
	
	public void remove(RealEstateRating realEstateRating) {
		realEstateRatingRepository.delete(realEstateRating);
	}
}
