package th.ac.rmutsb.pro.test.repository.room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import th.ac.rmutsb.pro.test.entity.room.RoomBookEntity;

@Repository
public interface RoomBooksRepository extends JpaRepository<RoomBookEntity, Long>{
	
	public List<RoomBookEntity> findByStatus(String status);
	public List<RoomBookEntity> findByStartDate(String startdate);
	public List<RoomBookEntity> findByEndDate(String enddate);
	public List<RoomBookEntity> findByStartTime(String starttime);
	public List<RoomBookEntity> findByEndTime(String endtime);
	public List<RoomBookEntity> findByRoomId(Long id);
}
