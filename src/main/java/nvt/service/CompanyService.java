package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Company;
import nvt.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	protected CompanyRepository companyRepository;
	
	
	public Company findById(int id) {
		return companyRepository.findOne(id);
	}
	
	public List<Company> findAll() {
		return  companyRepository.findAll();
	}
	
	public Page<Company> findAll(Pageable page) {
		return companyRepository.findAll(page);
	}
	
	public Company save(Company company) {
		return companyRepository.save(company);
	}
	
	public Company saveAndFlush(Company company) {
		return companyRepository.saveAndFlush(company);
	}
	
	public void removeById(int id) {
		companyRepository.delete(id);
	}
	
	public void remove(Company company) {
		companyRepository.delete(company);
	}
	
	
}
