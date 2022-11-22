package login;

import java.sql.Date;

public class loginVO {
	private String id;
	private String pwd;
	private String name;
	
	private Date birthDate;
	private Boolean gender;
	private String address;
	private String phone;
	
	//필수입력사항만 저장
	public loginVO() {
		System.out.println("LoginVO 생성자 호출");
	}
	
	//모든 입력사항 저장
	public loginVO(String id, String pwd, String name, Date birthDate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birthDate = birthDate;
	}

	public loginVO(String id, String pwd, String name, Date birthDate, Boolean gender, String address, String phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		
		this.birthDate = birthDate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getGender() {
		return gender;
	}
	
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
