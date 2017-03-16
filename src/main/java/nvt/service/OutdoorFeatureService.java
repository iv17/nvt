package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.OutdoorFeature;
import nvt.repository.OutdoorFeatureRepository;

@Service
public class OutdoorFeatureService {

	@Autowired
	protected OutdoorFeatureRepository outdoorFeatureRepository;
	
	
	public OutdoorFeature findById(int id) {
		return outdoorFeatureRepository.findById(id);
	}
	
	public List<OutdoorFeature> findAll() {
		return outdoorFeatureRepository.findAll();
	}
	
	public Page<OutdoorFeature> findAll(Pageable page) {
		return outdoorFeatureRepository.findAll(page);
	}
	
	public OutdoorFeature save(OutdoorFeature outdoorFeature) {
		return outdoorFeatureRepository.save(outdoorFeature);
	}
	
	public OutdoorFeature saveAndFlush(OutdoorFeature outdoorFeature) {
		return outdoorFeatureRepository.saveAndFlush(outdoorFeature);
	}
	
	public void removeById(int id) {
		outdoorFeatureRepository.delete(id);
	}
	
	public void remove(OutdoorFeature outdoorFeature) {
		outdoorFeatureRepository.delete(outdoorFeature);
	}
}
