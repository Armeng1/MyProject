package th.ac.rmutsb.pro.test.repository.car;


import org.springframework.data.jpa.repository.JpaRepository;

import th.ac.rmutsb.pro.test.entity.car.Carentity;

public interface CarRepository extends JpaRepository<Carentity, Long>{

}
