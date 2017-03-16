package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Advertisement;
import nvt.repository.AdvertisementsRepository;

@Service
public class AdvertisementService {

	@Autowired
	AdvertisementsRepository advertisementsRepository;
	
	
	public Advertisement findById(int id) {
		return advertisementsRepository.findById(id);
	}
	
	public List<Advertisement> findAll() {
		return advertisementsRepository.findAll();
	}
	
	public Page<Advertisement> findAll(Pageable page) {
		return advertisementsRepository.findAll(page);
	}
	
	public Advertisement save(Advertisement advertisement) {
		return advertisementsRepository.save(advertisement);
	}
	
	public Advertisement saveAndFlush(Advertisement advertisement) {
		return advertisementsRepository.saveAndFlush(advertisement);
	}
	
	public void removeById(int id) {
		advertisementsRepository.delete(id);
	}
	
	public void remove(Advertisement advertisement) {
		advertisementsRepository.delete(advertisement);
	}
	
	
}
