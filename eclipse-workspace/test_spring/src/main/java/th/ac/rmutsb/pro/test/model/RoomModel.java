package th.ac.rmutsb.pro.test.model;

public class RoomModel {
	private long Id;
	private String roomName;
	private String photo;
	private int roomLimit;
	private String roomDetail;
	
	public RoomModel() {
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getRoomLimit() {
		return roomLimit;
	}

	public void setRoomLimit(int roomLimit) {
		this.roomLimit = roomLimit;
	}

	public String getRoomDetail() {
		return roomDetail;
	}

	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}

	
}
