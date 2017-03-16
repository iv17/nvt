package nvt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.IndoorFeature;
import nvt.repository.IndoorFeatureRepository;

@Service
public class IndoorFeatureService {

	@Autowired
	protected IndoorFeatureRepository indoorFeatureRepository;
	
	
	public IndoorFeature findById(int id) {
		return indoorFeatureRepository.findById(id);
	}
	
	public List<IndoorFeature> findAll() {
		return indoorFeatureRepository.findAll();
	}
	
	public Page<IndoorFeature> findAll(Pageable page) {
		return indoorFeatureRepository.findAll(page);
	}
	
	public IndoorFeature save(IndoorFeature indoorFeature) {
		return indoorFeatureRepository.save(indoorFeature);
	}
	
	public IndoorFeature saveAndFlush(IndoorFeature indoorFeature) {
		return indoorFeatureRepository.saveAndFlush(indoorFeature);
	}
	
	public void removeById(int id) {
		indoorFeatureRepository.delete(id);
	}
	
	public void remove(IndoorFeature indoorFeature) {
		indoorFeatureRepository.delete(indoorFeature);
	}
}
