package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.IndoorFeature;

public interface IndoorFeatureRepository extends JpaRepository<IndoorFeature, Integer> {

	IndoorFeature findById(int id);
	List<IndoorFeature> findAll();
}
