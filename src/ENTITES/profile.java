package ENTITES;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="user_profile")
public class profile {
@Id
@Column(name="university_id")
@NotBlank(message="please fill the id")
@Length(max=10,message="not matching the format length")
@Pattern(regexp="^UB-[A-Z]{3}-[0-9]{3}$", message="UB-CSC-000")
private String id;


@NotBlank(message="please fill the name")
@Length(min=3,max=27,message="fill the proper first_name")
@Column(name="FIRST_NAME",columnDefinition="varchar(27) not null")
private String firstname;

@NotBlank(message="please fill the name")
@Length(min=3,max=27,message="fill the proper last_name")
@Column(name="LAST_NAME",columnDefinition="varchar(27) not null")
private String lastname;

@NotNull (message="please fill the values") 
@Range(min=18,max=70,message="please enter the correct age")
@Digits(integer=2,fraction=0,message="invalid age")
@Column(name="Age",precision=2)
private int age;


@NotBlank(message="please fill the id")
@Column(columnDefinition="varchar(28) not null")
private String role;

@DateTimeFormat(pattern ="dd-mm-yyyy")
@Past(message="please enter the correct dob")
@NotNull(message="please fill the DOB")
@Column(name="date_of_birth")
private Date DOB;


@Column(name="gender",columnDefinition="varchar(6) not null")
private String gender;


@Column(columnDefinition="varchar(12) not null")
private String department;

@Email(message="not proper email format")
@Column(columnDefinition="varchar(34) not null",name="email",unique=true)
private String email_id;


@Column(columnDefinition="varchar(12) not null",name="phone_number",unique=true)
private String number;

@NotBlank(message="please fill the address")
@Column(columnDefinition="LONGTEXT ")
private String address;

@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="username",columnDefinition="varchar(21)")
private user obj;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public Date getDOB() {
	return DOB;
}

public void setDOB(Date dOB) {
	DOB = dOB;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getEmail_id() {
	return email_id;
}

public void setEmail_id(String email_id) {
	this.email_id = email_id;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public user getObj() {
	return obj;
}

public void setObj(user obj) {
	this.obj = obj;
}

public profile() {
	super();
	// TODO Auto-generated constructor stub
}

public profile(String id, String firstname, String lastname, int age, String role, Date dOB, String gender,
		String department, String email_id, String number, String address, user obj) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
	this.role = role;
	DOB = dOB;
	this.gender = gender;
	this.department = department;
	this.email_id = email_id;
	this.number = number;
	this.address = address;
	this.obj = obj;
}





}
