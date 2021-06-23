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


import th.ac.rmutsb.pro.test.entity.room.RoomEntity;
import th.ac.rmutsb.pro.test.entity.room.RoomBookEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.RoomBookModel;
import th.ac.rmutsb.pro.test.repository.room.RoomBooksRepository;
import th.ac.rmutsb.pro.test.repository.room.RoomRepository;

@RequestMapping("/book")
@RestController
public class RoomBookApi {
	
	@Autowired private RoomBooksRepository regisReps;
	@Autowired private RoomRepository reps;
	
	@GetMapping("/{id}")
    public RoomBookEntity getBook(@PathVariable(value= "id")Long Id) {
        return this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+Id+" "+"not found"));
    }
	
	@GetMapping("/status")
	public List<RoomBookEntity> getStatus() {
        return this.regisReps.findByStatus("1");
    }
    
	
    @GetMapping("/lists")
    public List<RoomBookEntity> getRooms() {
        return this.regisReps.findAll();
    }
    
    @GetMapping
    public Page<RoomBookEntity> getBookPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.regisReps.findAll(PageRequest.of(page, size));
    }
    
    @PostMapping
    public RoomBookEntity createBook(@RequestBody RoomBookModel roombook) {
    	//System.out.println("room name : " + book.getRoomName());
    	RoomBookEntity entity = new RoomBookEntity();
    	entity.setEmail(roombook.getEmail());
    	entity.setName(roombook.getName());
    	entity.setTitle(roombook.getTitle());
    	entity.setStartDate(roombook.getStartDate());
    	entity.setEndDate(roombook.getEndDate());
    	entity.setStartTime(roombook.getStartTime());
    	entity.setEndTime(roombook.getEndTime());
    	entity.setRemark(roombook.getRemark());
    	entity.setStatus(roombook.getStatus());
    	//entity.setOpenStatus(roombook.getIsopen());
    	Optional<RoomEntity> op = this.reps.findById(roombook.getRoomId());
    	if(op.isPresent()) {
    		entity.setRoom(op.get());
    	}
    	return this.regisReps.save(entity);
    	//return this.regisReps.save(room);
    }

    @DeleteMapping("/{id}")
    public RoomBookEntity deleteBook(@PathVariable(value= "id")Long Id) {
    	RoomBookEntity book = this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
        this.regisReps.delete(book);
        return book;
    }
    
    @PutMapping("/{id}")
    public RoomBookEntity updateBook(@PathVariable (value= "id") Long Id, @RequestBody RoomBookEntity book) {
    	RoomBookEntity editbook = this.regisReps.findById(Id)
    		.orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
    	editbook.setEmail(book.getEmail());
    	editbook.setName(book.getName());
    	editbook.setTitle(book.getTitle());
    	editbook.setStartDate(book.getStartDate());
    	editbook.setEndDate(book.getEndDate());
    	editbook.setStartTime(book.getStartTime());
    	editbook.setEndTime(book.getEndTime());
    	editbook.setRemark(book.getRemark());
    	editbook.setStatus(book.getStatus());
    	editbook.setRoom(book.getRoom());
    	//editbook.setOpenStatus(book.getIsopen());
    	return this.regisReps.save(editbook);
    }
}