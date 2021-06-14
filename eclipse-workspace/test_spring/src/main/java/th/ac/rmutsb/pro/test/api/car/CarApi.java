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

import th.ac.rmutsb.pro.test.entity.car.Carentity;
import th.ac.rmutsb.pro.test.exception.ResourceNotFoundException;
import th.ac.rmutsb.pro.test.repository.car.CarRepository;

@RestController
@RequestMapping("/car")
public class CarApi {
	@Autowired private CarRepository reps;
	
	
	@GetMapping("/{id}")
	public Carentity getCars(@PathVariable(value = "id") Long carId){
		return this.reps.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car"+carId+" not found"));
	}
	@GetMapping("/lists")
	public List<Carentity> getCars() {
		return this.reps.findAll();
	}
	@GetMapping
	 public Page<Carentity> getCarsPages(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "10") int size) {
	  return this.reps.findAll(PageRequest.of(page, size));
	 }
	
	@PostMapping
	public Carentity createCar(@RequestBody Carentity car) {
		return this.reps.save(car);
	}
	
	@DeleteMapping("/{id}")
	public Carentity deleteCar(@PathVariable(value = "id") Long carId){
		Carentity car = this.reps.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("car"+carId+" not found"));
				this.reps.delete(car);
				return car;
				
	}
    @PutMapping("/{id}")
    public Carentity updatecar(@PathVariable (value= "id") Long carId, @RequestBody Carentity car) {
    	Carentity editcar = this.reps.findById(carId)
            .orElseThrow(() -> new ResourceNotFoundException("room"+" "+carId+" "+"not found"));
    	editcar.setCarBrand(car.getCarBrand());
        editcar.setCarNumber(car.getCarNumber());
    	editcar.setCarPhoto(car.getCarPhoto());
    	editcar.setCarSize(car.getCarSize());
    	editcar.setCarDetail(car.getCarDetail());
    	editcar.setCarColor(car.getCarColor());
        return this.reps.save(editcar);
    }
}

