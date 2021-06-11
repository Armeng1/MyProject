package th.ac.rmutsb.pro.test.entity.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carentity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long carId;

	 private String carPhoto;
	 private String carColor;
	 private String carBrand;
	 private String carNumber;

	 

		/*@ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="car_type" ,insertable = true, updatable = true)
	    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	    private CarTypeEntity carType;*/
		
		public long getCarId() {
			return carId;
		}
		public void setCarId(long carId) {
			this.carId = carId;
		}
		public String getCarPhoto() {
			return carPhoto;
		}
		public void setCarPhoto(String carPhoto) {
			this.carPhoto = carPhoto;
		}
		public String getCarColor() {
			return carColor;
		}
		public void setCarColor(String carColor) {
			this.carColor = carColor;
		}
		public String getCarBrand() {
			return carBrand;
		}
		public void setCarBrand(String carBrand) {
			this.carBrand = carBrand;
		}
		public String getCarNumber() {
			return carNumber;
		}
		public void setCarNumber(String carNumber) {
			this.carNumber = carNumber;
		}

		/*@Override
	    public String toString() {
	        return "Carentity [carId=" + carId + ", carPhoto=" + carPhoto + ", carRegistration=" + carRegistration + ","
	        		+ " carColor=" + carColor + ", carBrand=" + carBrand +" , carNumber=" + carNumber +"]";
	    }*/

}
