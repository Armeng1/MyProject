package th.ac.rmutsb.pro.test.repository.car;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import th.ac.rmutsb.pro.test.entity.car.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long>{
	
	public List<CarEntity> findBySizeGreaterThanEqual(int size);
}
