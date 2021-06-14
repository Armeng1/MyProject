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
	
		private String carBrand;
		private String carNumber;
		private String carPhoto;
		private String carSize;
		private String carDetail;
	 

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
		public String getCarPhoto() {
			return carPhoto;
		}
		public void setCarPhoto(String carPhoto) {
			this.carPhoto = carPhoto;
		}
		public String getCarSize() {
			return carSize;
		}
		public void setCarSize(String carSize) {
			this.carSize = carSize;
		}
		public String getCarDetail() {
			return carDetail;
		}
		public void setCarDetail(String carDetail) {
			this.carDetail = carDetail;
		}
		public String getCarColor() {
			return carColor;
		}
		public void setCarColor(String carColor) {
			this.carColor = carColor;
		}
		private String carColor;

	
		/*@Override
	    public String toString() {
	        return "Carentity [carId=" + carId + ", carPhoto=" + carPhoto + ", carRegistration=" + carRegistration + ","
	        		+ " carColor=" + carColor + ", carBrand=" + carBrand +" , carNumber=" + carNumber +"]";
	    }*/

}
