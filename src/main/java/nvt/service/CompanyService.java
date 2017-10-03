package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import nvt.beans.Company;
import nvt.conf.TokenUtils;
import nvt.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	protected CompanyRepository companyRepository;
	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;
	
	
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

	public Company findByUsername(String username) {
		return companyRepository.findByUsername(username);
	}
	
	public Company findByToken(String token) {
		String username = tokenUtils.getUsernameFromToken(token);
		UserDetails details = userDetailsService.loadUserByUsername(username);

		Company user = findByUsername(details.getUsername());
		return user;
	}
	
}
