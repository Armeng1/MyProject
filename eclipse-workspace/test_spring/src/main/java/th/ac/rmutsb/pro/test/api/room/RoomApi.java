package th.ac.rmutsb.pro.test.api.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import th.ac.rmutsb.pro.test.entity.room.RoomBookEntity;
import th.ac.rmutsb.pro.test.entity.room.RoomEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.RoomBookModel;
import th.ac.rmutsb.pro.test.repository.room.RoomBooksRepository;
import th.ac.rmutsb.pro.test.repository.room.RoomRepository;

@RequestMapping("/room")
@RestController
public class RoomApi {

    @Autowired private RoomRepository reps;
    @Autowired private RoomBooksRepository rbReps;


    @GetMapping("/{id}")
    public RoomEntity getRoom(@PathVariable(value= "id")Long id) {
        return this.reps.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
    }
    
    @GetMapping("/lists")
    public List<RoomEntity> getRooms() {
        return this.reps.findAll();
    }

    @GetMapping
    public Page<RoomEntity> getRoomsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.reps.findAll(PageRequest.of(page, size));
    }
    
    @GetMapping("/limits")
    public List<RoomEntity> getLimits( 
    		@RequestParam(required=true ,value="startDate") String stDate,
    		@RequestParam(required=true ,value="startTime") String stTime,
    		@RequestParam(required=true ,value="endDate") String enDate,
    		@RequestParam(required=true ,value="endTime") String enTime 
    		) {
    	List<RoomEntity> result = new ArrayList<RoomEntity>();
    	//B		21-06-2021	13.00	21-06-2021	15.00
    	List<RoomEntity> list = this.reps.findByRoomLimitGreaterThanEqual(0);// where roomlimit >= 0 , roomlimit = 0
    	//list = A , B , C
    	for(int i = 0; i < list.size(); i++) {
    		RoomEntity re = list.get(i);
    		//this.rbReps.find/
    		//where roomid = ? and startDate = reqStartDate
    		boolean isAdd = true;
    		List<RoomBookEntity> listRb = new ArrayList();//this.rbReps.findBy....
    		//B	21-06-2021  8.00   21-06-2021  10.00
    		//B	21-06-2021  14.00   21-06-2021  15.00
    		for(int x = 0; x < listRb.size(); x++) {
    			RoomBookEntity rb = listRb.get(i);
    			
    			//rb.getStartDate() rb.getStartTime()        stDate stTime         rb.getEndDate()  rb.getEndTime()
    			//rb.getStartDate() rb.getStartTime()        enDate enTime         rb.getEndDate()  rb.getEndTime()
    			//stDate stTime  		rb.getStartDate() rb.getStartTime()  &  rb.getEndDate()  rb.getEndTime()   enDate enTime
    			if(true) {
    				isAdd = false;
    				break;
    			}
    		}
    		
    		if(isAdd) {
    			result.add(re);
    		}
    	}
        return result;
    }
    


    @PostMapping
    public RoomEntity createRoom(@RequestBody RoomEntity room) {
        return this.reps.save(room);
    }
    
    @DeleteMapping("/{id}")
    public RoomEntity deleteRoom(@PathVariable(value= "id")Long id) {
        RoomEntity room = this.reps.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
        this.reps.delete(room);
        return room;
    }

    @PutMapping("/{id}")
    public RoomEntity updateRoom(@PathVariable (value= "id") Long id, @RequestBody RoomEntity room) {
    	RoomEntity editroom = this.reps.findById(id)
    		.orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
    	editroom.setRoomName(room.getRoomName());
    	editroom.setPhoto(room.getPhoto());
    	editroom.setRoomLimit(room.getRoomLimit());
    	editroom.setRoomDetail(room.getRoomDetail());
    	return this.reps.save(editroom);
    }
}
