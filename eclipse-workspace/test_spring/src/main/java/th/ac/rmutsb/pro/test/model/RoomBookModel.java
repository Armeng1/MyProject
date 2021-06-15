package th.ac.rmutsb.pro.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RoomBookModel {
	private long roomBook;
	private String email;
	private String name;
	private String title;
	private String roomName;
	
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


	public long getRoomBook() {
		return roomBook;
	}
	public void setRoomBook(long roomBook) {
		this.roomBook = roomBook;
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
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
	
	
}
