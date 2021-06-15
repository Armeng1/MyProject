package th.ac.rmutsb.pro.test.api.car;

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

import th.ac.rmutsb.pro.test.entity.car.BooksCarEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.repository.car.CarBooksRepository;



@RequestMapping("/bkcar")
@RestController
public class CarBookApi {
@Autowired private CarBooksRepository regisReps;
	
	@GetMapping("/{id}")
    public BooksCarEntity getBkcar(@PathVariable(value= "id")Long Id) {
        return this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("car"+" "+Id+" "+"not found"));
    }
	
    @GetMapping("/lists")
    public List<BooksCarEntity> getBkcar() {
        return this.regisReps.findAll();
    }
    
    @GetMapping
    public Page<BooksCarEntity> getBkcarPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.regisReps.findAll(PageRequest.of(page, size));
    }
    
    @PostMapping
    public BooksCarEntity createBook(@RequestBody BooksCarEntity bkcar) {
        return this.regisReps.save(bkcar);
      }

    @DeleteMapping("/{id}")
    public BooksCarEntity deleteBkcar(@PathVariable(value= "id")Long Id) {
    	BooksCarEntity bkcar = this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("bkcar"+" "+Id+" "+"not found"));
        this.regisReps.delete(bkcar);
        return bkcar;
    }
    
    @PutMapping("/{id}")
    public BooksCarEntity updateBkcar(@PathVariable (value= "id") Long Id, @RequestBody BooksCarEntity bkcar) {
    	BooksCarEntity editbkcar = this.regisReps.findById(Id)
    		.orElseThrow(() -> new ResourceNotFoundException("bkcar"+" "+Id+" "+"not found"));
    	editbkcar.setCarModel(bkcar.getCarModel());
    	editbkcar.setEmail(bkcar.getEmail());
    	editbkcar.setName(bkcar.getName());
    	editbkcar.setTitle(bkcar.getTitle());
    	editbkcar.setStartDate(bkcar.getStartDate());
    	editbkcar.setEndDate(bkcar.getEndDate());
    	editbkcar.setStartTime(bkcar.getStartTime());
    	editbkcar.setEndTime(bkcar.getEndTime());
    	editbkcar.setRemark(bkcar.getRemark());
    	editbkcar.setStatus(bkcar.getStatus());
    	return this.regisReps.save(editbkcar);
    }
}
