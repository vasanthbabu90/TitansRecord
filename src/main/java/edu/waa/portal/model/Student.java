package edu.waa.portal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@NotEmpty
	private String fullName;
	private Date dob;
	
	@NotEmpty
	private String gender;
	
	@Email
	private String email;
	private String password;
	private Date entryDate;
	
	@Column(nullable=true)
	//@UserName
	private String userName;
	
	@Column(nullable=true)
	private Boolean imageUploadedOrNot = false;
	@Transient //it will not save in DB
	@JsonIgnore  //to make it deserilize not serilize
 	private MultipartFile productImage;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Phone phone;


	public Student()
	{
		
	}
	


	

	public Student(String fullName, Date dob, String gender, String email, String password, String userName,
			Date entryDate) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.entryDate = entryDate;
	}



	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}





	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getImageUploadedOrNot() {
		return imageUploadedOrNot;
	}


	public void setImageUploadedOrNot(Boolean imageUploadedOrNot) {
		this.imageUploadedOrNot = imageUploadedOrNot;
	}


	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
