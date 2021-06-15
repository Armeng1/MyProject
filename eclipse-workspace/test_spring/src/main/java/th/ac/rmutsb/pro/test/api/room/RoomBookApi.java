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

import th.ac.rmutsb.pro.test.entity.room.BooksRoomEntity;
import th.ac.rmutsb.pro.test.entity.room.RoomEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.BookModel;
import th.ac.rmutsb.pro.test.repository.room.RoomBooksRepository;
import th.ac.rmutsb.pro.test.repository.room.RoomRepository;

@RequestMapping("/book")
@RestController
public class RoomBookApi {
	
	@Autowired private RoomBooksRepository regisReps;
	@Autowired private RoomRepository reps;
	
	@GetMapping("/{id}")
    public BooksRoomEntity getBook(@PathVariable(value= "id")Long Id) {
        return this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("room"+" "+Id+" "+"not found"));
    }
	
    @GetMapping("/lists")
    public List<BooksRoomEntity> getRooms() {
        return this.regisReps.findAll();
    }
    
    @GetMapping
    public Page<BooksRoomEntity> getBookPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.regisReps.findAll(PageRequest.of(page, size));
    }
    
    @PostMapping
    public BooksRoomEntity createBook(@RequestBody BookModel book) {
    	BooksRoomEntity entity = new BooksRoomEntity();
    	entity.setEmail(book.getEmail());
    	entity.setName(book.getName());
    	entity.setTitle(book.getTitle());
    	entity.setRoomName(book.getRoomName());
    	entity.setStartDate(book.getStartDate());
    	entity.setEndDate(book.getEndDate());
    	entity.setStartTime(book.getStartTime());
    	entity.setEndTime(book.getEndTime());
    	entity.setRemark(book.getRemark());
    	entity.setStatus(book.getStatus());
 
    	Optional<RoomEntity> op = this.reps.findById(book.getBookRoom());
    	if(op.isPresent()) {
    		entity.setRoom(op.get());
    	}
    	return this.regisReps.save(entity);
    	//return this.regisReps.save(room);
      }

    @DeleteMapping("/{id}")
    public BooksRoomEntity deleteBook(@PathVariable(value= "id")Long Id) {
    	BooksRoomEntity book = this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
        this.regisReps.delete(book);
        return book;
    }
    
    @PutMapping("/{id}")
    public BooksRoomEntity updateBook(@PathVariable (value= "id") Long Id, @RequestBody BooksRoomEntity book) {
    	BooksRoomEntity editbook = this.regisReps.findById(Id)
    		.orElseThrow(() -> new ResourceNotFoundException("book"+" "+Id+" "+"not found"));
    	editbook.setEmail(book.getEmail());
    	editbook.setName(book.getName());
    	editbook.setTitle(book.getTitle());
    	editbook.setRoomName(book.getRoomName());
    	editbook.setStartDate(book.getStartDate());
    	editbook.setEndDate(book.getEndDate());
    	editbook.setStartTime(book.getStartTime());
    	editbook.setEndTime(book.getEndTime());
    	editbook.setRemark(book.getRemark());
    	editbook.setStatus(book.getStatus());
    	return this.regisReps.save(editbook);
    }
}