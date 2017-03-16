package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.User;

public interface RealEstateCommentRepository extends JpaRepository<RealEstateComment, Integer> {

	RealEstateComment findById(int id);
	List<RealEstateComment> findAll();
	List<RealEstateComment> findByRealEstate(RealEstate realEstate);
	List<RealEstateComment> findByUser(User user);
}
