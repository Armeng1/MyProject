package th.ac.rmutsb.pro.test.repository.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.ac.rmutsb.pro.test.entity.car.BooksCarEntity;

@Repository
public interface CarBooksRepository extends JpaRepository<BooksCarEntity, Long>{

}
