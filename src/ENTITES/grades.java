package ENTITES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Grade")
public class grades {
	@NotBlank(message="please fill the name")
	@Length(min=3,max=27,message="fill the proper NAME")
	@Column(name="Name",columnDefinition="varchar(54) not null")
private String name;
@Column(name="University_id")
@NotBlank(message="please fill the id")
@Length(max=10,message="not matching the format length")
@Pattern(regexp="^UB-[A-Z]{3}-[0-9]{3}$", message="UB-CSC-000")
private String id;
@Column(name="Semester",columnDefinition="varchar(9)")
private String semester;
@Column(columnDefinition="varchar(9) not null",name="Department")
private String dept;
@Column(columnDefinition="varchar(3)",name="Homeworks")
private String assignment;
@Column(columnDefinition="varchar(3)",name="Projects")
private String project;
@Column(columnDefinition="varchar(3)",name="Mid")
private String midterm;
@Column(columnDefinition="varchar(3)",name="Finals")
private String finals;
@Column(columnDefinition="varchar(12)",name="Grades")
private String final_grade;
@Column(name="course_id",columnDefinition="varchar(12)")
@NotBlank(message="please fill the course_id")
@Length(max=12,message="not matching the format length")
@Pattern(regexp="^UB-[A-Z]{4}-[0-9]{4}$", message="example UB-CPCS-1000")
private String course_id;
public String getCourse_id() {
	return course_id;
}
public void setCourse_id(String course_id) {
	this.course_id = course_id;
}
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int main_id;
public int getMain_id() {
	return main_id;
}
public void setMain_id(int main_id) {
	this.main_id = main_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getAssignment() {
	return assignment;
}
public void setAssignment(String assignment) {
	this.assignment = assignment;
}
public String getProject() {
	return project;
}
public void setProject(String project) {
	this.project = project;
}
public String getMidterm() {
	return midterm;
}
public void setMidterm(String midterm) {
	this.midterm = midterm;
}
public String getFinals() {
	return finals;
}
public void setFinals(String finals) {
	this.finals = finals;
}
public String getFinal_grade() {
	return final_grade;
}
public void setFinal_grade(String final_grade) {
	this.final_grade = final_grade;
}
public grades() {
	super();
	// TODO Auto-generated constructor stub
}
public grades(String name, String id, String semester, String dept, String assignment, String project, String midterm,
		String finals, String final_grade, String course_id) {
	super();
	this.name = name;
	this.id = id;
	this.semester = semester;
	this.dept = dept;
	this.assignment = assignment;
	this.project = project;
	this.midterm = midterm;
	this.finals = finals;
	this.final_grade = final_grade;
	this.course_id = course_id;
}

}
