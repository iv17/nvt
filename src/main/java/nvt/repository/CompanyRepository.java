package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	Company findById(int id);
	Company findByUsername(String username);	
}
