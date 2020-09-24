package ENTITES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class user {
@Id	
@Column(columnDefinition="varchar(21)")
@NotBlank(message="please fill the username")
@Pattern(regexp="^[A-Z]{12}$", message="all caps")
@Length(max=12,message="characters max=12")
private String username;

@Column(columnDefinition="varchar(21) not null",name="pass")
@NotBlank(message="please fill the password")
@Length(max=21,message="combination of letters then numbers then specialcharacters max=12")
@Pattern(regexp="^[a-z]{3}[A-Z]{3}[0-9]{4}[@#$*!~]{2}", message="example:hemANT2345@$")
private String password;

@Valid
@OneToOne(mappedBy="obj")
private profile pro;


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public profile getPro() {
	return pro;
}
public void setPro(profile pro) {
	this.pro = pro;
}
public user(String username, String password, profile pro) {
	super();
	this.username = username;
	this.password = password;
	this.pro = pro;
}
public user() {
	super();
	// TODO Auto-generated constructor stub
}

}
