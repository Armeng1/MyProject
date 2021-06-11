package th.ac.rmutsb.pro.test.api.room;
/*package th.ac.rmutsb.pro.test.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import th.ac.rmutsb.pro.test.entity.RoomTypeEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.repository.RoomTypeRepository;

@RequestMapping("/typeroom")
@RestController
public class RoomTypeApi {
	
	 @Autowired private RoomTypeRepository typeReps;
	 
	 @GetMapping("/{id}")
	  public RoomTypeEntity getTypeRoom(@PathVariable(value= "id")Long typeroomID) {
		 return this.typeReps.findById(typeroomID)
				.orElseThrow(() -> new ResourceNotFoundException("typeroom"+" "+typeroomID+" "+"not found"));
	}
	
	 @GetMapping("/lists")
	    public List<RoomTypeEntity> getTypeRoom() {
	        return this.typeReps.findAll();
	}
	 
	 @GetMapping
	    public Page<RoomTypeEntity> getTypeRoomsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
	     return this.typeReps.findAll(PageRequest.of(page, size));
	}
	
	 @PostMapping
	    public RoomTypeEntity createTypeRoom(@RequestBody RoomTypeEntity typeroom) {
	      return this.typeReps.save(typeroom);
	}
	
	 @DeleteMapping("/{id}")
	    public RoomTypeEntity deleteTypeRoom(@PathVariable(value= "id")Long typeroomID) {
		 RoomTypeEntity typeroom = this.typeReps.findById(typeroomID)
	                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+typeroomID+" "+"not found"));
	        this.typeReps.delete(typeroom);
	        return typeroom;
	}
	 
	
	 
	 
}*/
