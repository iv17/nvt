package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.RealEstateReport;
import nvt.repository.RealEstateReportRepository;

@Service
public class RealEstateReportService {

	@Autowired
	RealEstateReportRepository realEstateReportRepository;
	
	
	public RealEstateReport findById(int id) {
		return realEstateReportRepository.findById(id);
	}
	
	public List<RealEstateReport> findAll() {
		return realEstateReportRepository.findAll();
	}
	
	public Page<RealEstateReport> findAll(Pageable page) {
		return realEstateReportRepository.findAll(page);
	}
	
	public RealEstateReport save(RealEstateReport realEstateReport) {
		return realEstateReportRepository.save(realEstateReport);
	}
	
	public RealEstateReport saveAndFlush(RealEstateReport realEstateReport) {
		return realEstateReportRepository.saveAndFlush(realEstateReport);
	}
	
	public void removeById(int id) {
		realEstateReportRepository.delete(id);
	}
	
	public void remove(RealEstateReport realEstateReport) {
		realEstateReportRepository.delete(realEstateReport);
	}
}
