package th.ac.rmutsb.pro.test.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import th.ac.rmutsb.pro.test.entity.room.RoomBookEntity;

@Repository
public interface RoomBooksRepository extends JpaRepository<RoomBookEntity, Long>{

}
