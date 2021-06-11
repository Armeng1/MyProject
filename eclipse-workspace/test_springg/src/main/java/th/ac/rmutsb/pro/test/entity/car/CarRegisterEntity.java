package th.ac.rmutsb.pro.test.entity.car;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CarRegisterEntity {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)

	    private Long codeID;
	    private String timeIn;
	    private String timeOut;
	    private int amountRegis;
	    private String remark;
	    private int status;
	    private String email;

	    public Long getCodeID() {
	        return codeID;
	    }
	    public void setCodeID(Long codeID) {
	        this.codeID = codeID;
	    }
	    public String getTimeIn() {
	        return timeIn;
	    }
	    public void setTimeIn(String timeIn) {
	        this.timeIn = timeIn;
	    }
	    public String getTimeOut() {
	        return timeOut;
	    }
	    public void setTimeOut(String timeOut) {
	        this.timeOut = timeOut;
	    }
	    public int getAmountRegis() {
	        return amountRegis;
	    }
	    public void setAmountRegis(int amountRegis) {
	        this.amountRegis = amountRegis;
	    }
	    public String getRemark() {
	        return remark;
	    }
	    public void setRemark(String remark) {
	        this.remark = remark;
	    }
	    public int getStatus() {
	        return status;
	    }
	    public void setStatus(int status) {
	        this.status = status;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
}