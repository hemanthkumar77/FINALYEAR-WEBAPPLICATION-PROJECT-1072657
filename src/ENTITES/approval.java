package ENTITES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
@Entity
@Table(name="approval_table")
public class approval {
	@Column(columnDefinition="varchar(12) not null")
	private String department;
	@Column(name="university_id")
	@NotBlank(message="please fill the id")
	@Length(max=10,message="not matching the format length")
	@Pattern(regexp="^UB-[A-Z]{3}-[0-9]{3}$", message="UB-CSC-000")
	private String id;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int main_id;
	@NotBlank(message="please fill the name")
	@Length(min=3,max=27,message="fill the proper NAME")
	@Column(name="NAME",columnDefinition="varchar(54) not null")
	private String firstname;
	@Column(name="course_id",columnDefinition="varchar(12)")
	@NotBlank(message="please fill the course_id")
	@Length(max=12,message="not matching the format length")
	@Pattern(regexp="^UB-[A-Z]{4}-[0-9]{4}$", message="example UB-CPCS-1000")
	private String course_id;

	
	@NotBlank(message="course_name")
	@Column(name="course_name",columnDefinition="varchar(27)")
	@Length(min=5,max=27,message="not matching the name length")
	private String course_name;

	@NotNull (message="fill the credits") 
	@Range(min=1,max=3,message="please enter the correct credits")
	@Digits(integer=1,fraction=0,message="invalid credit")
	@Column(name="course_credits",precision=1)
	private int credits;

	@NotBlank(message="professor_name")
	@Column(name="professor",columnDefinition="varchar(30)")
	private String staffname;

	@NotBlank(message="mention the days")
	@Column(name="days",columnDefinition="varchar(3)")
	private String days;

	@NotBlank(message="timings")
	@Column(name="time",columnDefinition="varchar(16)")
	private String timings;
	@Column(name="Semester",columnDefinition="varchar(9)")
	private String semester;
	
	@Column(name="HEAD",columnDefinition="varchar(9)")
	private String head;
	@Column(name="ADMIN",columnDefinition="varchar(9)")
	private String admin;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
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
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public approval() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
