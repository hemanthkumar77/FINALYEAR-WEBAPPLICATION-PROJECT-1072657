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
@Table(name="registered")
public class registered {
	@Column(name="university_id")
	@NotBlank(message="please fill the id")
	@Length(max=10,message="not matching the format length")
	@Pattern(regexp="^UB-[A-Z]{3}-[0-9]{3}$", message="UB-CSC-000")
private String id;
	
	@NotBlank(message="please fill the name")
	@Length(min=3,max=27,message="fill the proper NAME")
	@Column(name="NAME",columnDefinition="varchar(54) not null")
private String studentname;
	
	@Column(columnDefinition="varchar(12) not null")
private String department;
	
	@Column(name="course_id",columnDefinition="varchar(12)")
	@NotBlank(message="please fill the course_id")
	@Length(max=12,message="not matching the format length")
	@Pattern(regexp="^UB-[A-Z]{4}-[0-9]{4}$", message="example UB-CPCS-1000")
private String course_id;
	
	@NotBlank(message="course_name")
	@Column(name="course_name",columnDefinition="varchar(27)")
	@Length(min=5,max=27,message="not matching the name length")
private String course_name;
	@NotBlank(message="professor_name")
	@Column(name="professor",columnDefinition="varchar(30)")
private String staff_name;
	@NotNull (message="fill the credits") 
	@Range(min=1,max=3,message="please enter the correct credits")
	@Digits(integer=1,fraction=0,message="invalid credit")
	@Column(name="course_credits",precision=1)
private int credits;
	@Column(name="Semester",columnDefinition="varchar(9)")
	private String semester;
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	@Column(name="grades",columnDefinition="varchar(3)")
private String final_grade;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int main_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
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
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getFinal_grade() {
		return final_grade;
	}
	public void setFinal_grade(String final_grade) {
		this.final_grade = final_grade;
	}
	public int getMain_id() {
		return main_id;
	}
	public void setMain_id(int main_id) {
		this.main_id = main_id;
	}
	public registered() {
		super();
		// TODO Auto-generated constructor stub
	}
	public registered(String id, String studentname, String department, String course_id, String course_name,
			String staff_name, int credits, String semester) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.department = department;
		this.course_id = course_id;
		this.course_name = course_name;
		this.staff_name = staff_name;
		this.credits = credits;
		this.semester = semester;
	}

	
	
}
