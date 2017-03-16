package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateComment;
import nvt.repository.RealEstateCommentRepository;

@Service
public class RealEstateCommentService {

	@Autowired 
	RealEstateCommentRepository realEstateCommentRepository;
	
	
	public RealEstateComment findById(int id) {
		return realEstateCommentRepository.findById(id);
	}
	
	public List<RealEstateComment> findAll() {
		return realEstateCommentRepository.findAll();
	}
	
	public Page<RealEstateComment> findAll(Pageable page) {
		return realEstateCommentRepository.findAll(page);
	}
	
	public RealEstateComment save(RealEstateComment realEstateComment) {
		return realEstateCommentRepository.save(realEstateComment);
	}
	
	public RealEstateComment saveAndFlush(RealEstateComment realEstateComment) {
		return realEstateCommentRepository.saveAndFlush(realEstateComment);
	}
	
	public void removeById(int id) {
		realEstateCommentRepository.delete(id);
	}
	
	public void remove(RealEstateComment realEstateComment) {
		realEstateCommentRepository.delete(realEstateComment);
	}
}
