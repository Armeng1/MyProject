package th.ac.rmutsb.pro.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RoomBookModel {
	private long roomId;
	private String email;
	private String name;
	private String title;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private String startDate;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private String endDate;
	
	@JsonFormat(pattern = "HH:mm:ss a")
	private String startTime;
	
	@JsonFormat(pattern = "HH:mm:ss a")
	private String endTime;
	private String remark;
	private String status;
	//private int isopen;
	
	public RoomBookModel() {
	}
	
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/*public boolean isOpen() {
		return this.isopen == 1;
	}
	public void setOpenStatus(int status_code) {
		this.isopen = status_code;
	}
	public int getIsopen() {
		return isopen;
	}
	public void setIsopen(int isopen) {
		this.isopen = isopen;
	}*/

	
}
