package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateReport;

public interface RealEstateReportRepository extends JpaRepository<RealEstateReport, Integer> {

	RealEstateReport findById(int id);
	List<RealEstateReport> findAll();
	
}
