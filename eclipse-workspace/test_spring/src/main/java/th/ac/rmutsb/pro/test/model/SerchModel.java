package th.ac.rmutsb.pro.test.model;

public class SerchModel {
	
	private String serchId;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private int roomLimit;
	
	public SerchModel() {
	}

	
	public String getSerchId() {
		return serchId;
	}

	public void setSerchId(String serchId) {
		this.serchId = serchId;
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

	public int getRoomLimit() {
		return roomLimit;
	}

	public void setRoomLimit(int roomLimit) {
		this.roomLimit = roomLimit;
	}
	
	
	
}
