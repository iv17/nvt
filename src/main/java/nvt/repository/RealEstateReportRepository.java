package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstate;
import nvt.beans.RealEstateReport;
import nvt.beans.User;

public interface RealEstateReportRepository extends JpaRepository<RealEstateReport, Integer> {

	RealEstateReport findById(int id);
	List<RealEstateReport> findAll();
	List<RealEstateReport> findByRealEstate(RealEstate realEstate);
	List<RealEstateReport> findByUser(User user);
}
