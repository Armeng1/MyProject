package th.ac.rmutsb.pro.test.entity.room;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class RoomBookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	

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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_entity" ,insertable = true, updatable = true)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private RoomEntity room;
	

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public RoomEntity getRoom() {
		return room;
	}
	public void setRoom(RoomEntity room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "RoomBookEntity [Id=" + Id + ", email=" + email + ", name=" + name + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", remark="
				+ remark + ", status=" + status + ", room=" + room + "]";
	}
}
