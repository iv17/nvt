package nvt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nvt.beans.Image;
import nvt.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepository;
	
	
	public Image findById(int id) {
		return imageRepository.findById(id);
	}
	
	public List<Image> findAll() {
		return imageRepository.findAll();
	}
	
	public Page<Image> findAll(Pageable page) {
		return imageRepository.findAll(page);
	}
	
	public Image save(Image Image) {
		return imageRepository.save(Image);
	}
	
	public Image saveAndFlush(Image Image) {
		return imageRepository.saveAndFlush(Image);
	}
	
	public void removeById(int id) {
		imageRepository.delete(id);
	}
	
	public void remove(Image Image) {
		imageRepository.delete(Image);
	}
	
}
