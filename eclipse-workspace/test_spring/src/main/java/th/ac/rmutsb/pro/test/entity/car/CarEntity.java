package th.ac.rmutsb.pro.test.entity.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long carId;
	
		private String carBrand;
		private String carNumber;
		private String carPhoto;
		private int size;
		private String detail;
		private String carColor;
	 

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
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getCarColor() {
			return carColor;
		}
		public void setCarColor(String carColor) {
			this.carColor = carColor;
		}
		

	
		/*@Override
	    public String toString() {
	        return "Carentity [carId=" + carId + ", carPhoto=" + carPhoto + ", carRegistration=" + carRegistration + ","
	        		+ " carColor=" + carColor + ", carBrand=" + carBrand +" , carNumber=" + carNumber +"]";
	    }*/

}
