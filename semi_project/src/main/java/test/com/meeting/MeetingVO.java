package test.com.meeting;

public class MeetingVO {
	private long meeting_id;
	private String name;
	private String explanation;
	private String gender;
	private String age;
	private String location;
	private int total_people;
	private String permission; // 가입 승낙 필요
	private String secret; // 공개형 비공개형

	// meetingImage
	private String image_url;

	public MeetingVO() {
		// TODO Auto-generated constructor stub
	}

	

	public MeetingVO(long meeting_id, String name, String explanation, String gender, String age, String location,
			int total_people, String permission, String secret, String image_url) {
		super();
		this.meeting_id = meeting_id;
		this.name = name;
		this.explanation = explanation;
		this.gender = gender;
		this.age = age;
		this.location = location;
		this.total_people = total_people;
		this.permission = permission;
		this.secret = secret;
		this.image_url = image_url;
	}



	public long getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(long meeting_id) {
		this.meeting_id = meeting_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getTotal_people() {
		return total_people;
	}

	public void setTotal_people(int total_people) {
		this.total_people = total_people;
	}

	
}