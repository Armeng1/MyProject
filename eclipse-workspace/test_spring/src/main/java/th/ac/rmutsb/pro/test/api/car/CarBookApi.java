package th.ac.rmutsb.pro.test.api.car;

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

import th.ac.rmutsb.pro.test.entity.car.BooksCarEntity;
import th.ac.rmutsb.pro.test.entity.car.CarEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.model.CarBookModel;
import th.ac.rmutsb.pro.test.repository.car.CarBooksRepository;
import th.ac.rmutsb.pro.test.repository.car.CarRepository;



@RequestMapping("/bkcar")
@RestController
public class CarBookApi {
@Autowired private CarBooksRepository regisReps;
@Autowired private CarRepository reps;
	
	@GetMapping("/{id}")
    public BooksCarEntity getBkcar(@PathVariable(value= "id")Long Id) {
        return this.regisReps.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("car"+" "+Id+" "+"not found"));
    }
	
    @GetMapping("/lists")
    public List<BooksCarEntity> getCars() {
        return this.regisReps.findAll();
    }
    
    @GetMapping
    public Page<BooksCarEntity> getBkcarPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
    	return this.regisReps.findAll(PageRequest.of(page, size));
    }
    
    @PostMapping
    public BooksCarEntity createBook(@RequestBody CarBookModel bkcar) {
    	BooksCarEntity entitycar = new BooksCarEntity();
    	entitycar.setEmail(bkcar.getEmail());
    	entitycar.setName(bkcar.getName());
    	entitycar.setTitle(bkcar.getTitle());
    	entitycar.setStartDate(bkcar.getStartDate());
    	entitycar.setEndDate(bkcar.getEndDate());
    	entitycar.setStartTime(bkcar.getStartTime());
    	entitycar.setEndTime(bkcar.getEndTime());
    	entitycar.setRemark(bkcar.getRemark());
    	entitycar.setStatus(bkcar.getStatus());
    	
    	Optional<CarEntity> opcar = this.reps.findById(bkcar.getCarId());
    	if(opcar.isPresent()) {
    		entitycar.setCar(opcar.get());
    	}
    	return this.regisReps.save(entitycar);
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
    	//editbkcar.setCarModel(bkcar.getCarModel());
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
