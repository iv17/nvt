package nvt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nvt.beans.OutdoorFeature;

public interface OutdoorFeatureRepository extends JpaRepository<OutdoorFeature, Integer> {

	OutdoorFeature findById(int id);
	List<OutdoorFeature> findAll();
}
