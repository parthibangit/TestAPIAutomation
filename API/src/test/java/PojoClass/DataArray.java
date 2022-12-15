package PojoClass;

public class DataArray {
	
	private String name;
	private String email;
	private String gender;
	private String status;
	private int id;
	private String created_at;
	private String updated_at;
	

	public String getCreated_at() {
		return created_at;
	}
	
	public String getUpdated_at() {
		return updated_at;
	}
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Response: [name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status + ", id=" + id
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	

}
