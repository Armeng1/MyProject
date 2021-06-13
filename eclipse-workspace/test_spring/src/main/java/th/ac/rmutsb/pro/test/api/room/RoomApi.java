package th.ac.rmutsb.pro.test.api.room;

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

import th.ac.rmutsb.pro.test.entity.room.RoomsEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.RoomModel;
import th.ac.rmutsb.pro.test.repository.room.RoomRepository;

@RequestMapping("/room")
@RestController
public class RoomApi {

    @Autowired private RoomRepository reps;


    @GetMapping("/{id}")
    public RoomsEntity getRoom(@PathVariable(value= "id")Long id) {
        return this.reps.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
    }

    @GetMapping("/lists")
    public List<RoomsEntity> getRooms() {
        return this.reps.findAll();
    }

    @GetMapping
    public Page<RoomsEntity> getRoomsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.reps.findAll(PageRequest.of(page, size));
    }

    @PostMapping
    public RoomsEntity createRoom(@RequestBody RoomsEntity room) {
        return this.reps.save(room);
      }
    

    @DeleteMapping("/{id}")
    public RoomsEntity deleteRoom(@PathVariable(value= "id")Long id) {
        RoomsEntity room = this.reps.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
        this.reps.delete(room);
        return room;
    }

    @PutMapping("/{id}")
    public RoomsEntity updateRoom(@PathVariable (value= "id") Long id, @RequestBody RoomsEntity room) {
    	RoomsEntity editroom = this.reps.findById(id)
    		.orElseThrow(() -> new ResourceNotFoundException("room"+" "+id+" "+"not found"));
    	editroom.setRoomName(room.getRoomName());
    	editroom.setPhoto(room.getPhoto());
    	editroom.setTitle(room.getTitle());
    	editroom.setRoomLimit(room.getRoomLimit());
    	editroom.setRoomDetail(room.getRoomDetail());
    	editroom.setRemark(room.getRemark());
    	return this.reps.save(editroom);
    }
}
