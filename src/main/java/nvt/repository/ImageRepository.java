package nvt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer> {

	Image findById(int id);
	
}
