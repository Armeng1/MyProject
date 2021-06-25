package th.ac.rmutsb.pro.test.api.car;

import java.util.ArrayList;
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
import th.ac.rmutsb.pro.test.entity.car.CarEntity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.helper.StampHelper;
import th.ac.rmutsb.pro.test.repository.car.CarBooksRepository;
import th.ac.rmutsb.pro.test.repository.car.CarRepository;

@RestController
@RequestMapping("/car")
public class CarApi {
	@Autowired private CarRepository reps;
	@Autowired private CarBooksRepository regisReps;
	
	@GetMapping("/{id}")
	public CarEntity getCars(@PathVariable(value = "id") Long carId){
		return this.reps.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car"+carId+" not found"));
	}
	@GetMapping("/lists")
	public List<CarEntity> getCars() {
		return this.reps.findAll();
	}
	@GetMapping
	 public Page<CarEntity> getCarsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
	  return this.reps.findAll(PageRequest.of(page, size));
	 }
	 @GetMapping("/limits")
	    public List<CarEntity> getLimits( 
	    		//@RequestParam(required=true ,value="size") int size,
	    		@RequestParam(required=true ,value="startDate") String stDate,
	    		@RequestParam(required=true ,value="startTime") String stTime,
	    		@RequestParam(required=true ,value="endDate") String enDate,
	    		@RequestParam(required=true ,value="endTime") String enTime 
	    		) {
	    	List<CarEntity> result = new ArrayList<CarEntity>();
	    	List<CarEntity> list = this.reps.findAll();
	    	for(int i = 0; i < list.size(); i++) {
	    		CarEntity ce = list.get(i);
	    		boolean isAdd = true;
	    		List<BooksCarEntity> listCb = this.regisReps.findByCarCarId(ce.getCarId());
	    		for(int x = 0; x < listCb.size(); x++) {
	    			BooksCarEntity cb = listCb.get(x);
	    			 if (StampHelper.isOverlapping(
	                         StampHelper.convertTimeStamp(cb.getStartDate(),cb.getStartTime()),
	                         StampHelper.convertTimeStamp(cb.getEndDate(),cb.getEndTime()),
	                         StampHelper.convertTimeStamp(stDate,stTime),
	                         StampHelper.convertTimeStamp(enDate,enTime)
	                         )) {
	    				isAdd = false;
	    				break;
	    			}
	    		}
	    		
	    		if(isAdd) {
	    			result.add(ce);
	    		}
	    	}
	        return result;
	    }
	
	@PostMapping
	public CarEntity createCar(@RequestBody CarEntity car) {
		return this.reps.save(car);
	}
	
	@DeleteMapping("/{id}")
	public CarEntity deleteCar(@PathVariable(value = "id") Long carId){
		CarEntity car = this.reps.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car"+carId+" not found"));
				this.reps.delete(car);
				return car;
				
	}
    @PutMapping("/{id}")
    public CarEntity updatecar(@PathVariable (value= "id") Long carId, @RequestBody CarEntity car) {
    	CarEntity editcar = this.reps.findById(carId)
            .orElseThrow(() -> new ResourceNotFoundException("room"+" "+carId+" "+"not found"));
    	editcar.setCarBrand(car.getCarBrand());
        editcar.setCarNumber(car.getCarNumber());
    	editcar.setCarPhoto(car.getCarPhoto());
    	editcar.setSize(car.getSize());
    	editcar.setDetail(car.getDetail());
    	editcar.setCarColor(car.getCarColor());
        return this.reps.save(editcar);
    }
}

