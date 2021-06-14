package th.ac.rmutsb.pro.test.api.room;

import java.util.List;

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
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.repository.room.RoomBooksRepository;

@RequestMapping("/book")
@RestController
public class RoomBookApi {
	
	@Autowired private RoomBooksRepository regisReps;
	
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
    public BooksRoomEntity createBook(@RequestBody BooksRoomEntity room) {
        return this.regisReps.save(room);
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
    	editbook.setRoom(book.getRoom());
    	editbook.setStartDate(book.getStartDate());
    	editbook.setEndDate(book.getEndDate());
    	editbook.setStartTime(book.getStartTime());
    	editbook.setEndTime(book.getEndTime());
    	editbook.setRemark(book.getRemark());
    	editbook.setStatus(book.getStatus());
    	return this.regisReps.save(editbook);
    }
}