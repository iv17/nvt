package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstateComment;

public interface RealEstateCommentRepository extends JpaRepository<RealEstateComment, Integer> {

	RealEstateComment findById(int id);
	List<RealEstateComment> findAll();
}
