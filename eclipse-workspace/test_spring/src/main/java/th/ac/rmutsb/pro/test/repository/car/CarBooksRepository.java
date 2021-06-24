package th.ac.rmutsb.pro.test.repository.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.ac.rmutsb.pro.test.entity.car.BooksCarEntity;


@Repository
public interface CarBooksRepository extends JpaRepository<BooksCarEntity, Long>{
	
	public List<BooksCarEntity> findByStatus(String status);
	public List<BooksCarEntity> findByStartDate(String startdate);
	public List<BooksCarEntity> findByEndDate(String enddate);
	public List<BooksCarEntity> findBystartTime(String starttime);
	public List<BooksCarEntity> findByEndTime(String endtime);
	public List<BooksCarEntity> findByCarCarId(Long carid);
}
