package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.WorkingTime;
import nvt.repository.WorkingTimeRepository;

@Service
public class WorkingTimeService {

	@Autowired
	WorkingTimeRepository workingTimeRepository;
	
	public WorkingTime findById(int id) {
		return workingTimeRepository.findById(id);
	}
	
	public List<WorkingTime> findAll() {
		return workingTimeRepository.findAll();
	}
	
	public Page<WorkingTime> findAll(Pageable page) {
		return workingTimeRepository.findAll(page);
	}
	
	public WorkingTime save(WorkingTime workingTime) {
		return workingTimeRepository.save(workingTime);
	}
	
	public WorkingTime saveAndFlush(WorkingTime workingTime) {
		return workingTimeRepository.saveAndFlush(workingTime);
	}
	
	public void removeById(int id) {
		workingTimeRepository.delete(id);
	}
	
	public void remove(WorkingTime workingTime) {
		workingTimeRepository.delete(workingTime);
	}
	
	
}
