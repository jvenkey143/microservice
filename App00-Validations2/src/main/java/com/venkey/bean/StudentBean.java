package com.venkey.bean;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class StudentBean {
	
	@NotEmpty
	@Size(min = 5,max = 5)
	private String stdId;
	
	@NotEmpty
	@Size(min = 5,max = 10)
	private String stdName;
	
	@NotNull @Min(20) @Max(40)
	private Integer age;
	
	@NotNull
	private Gender gender;
	
	@Past
	@NotNull
	private Date dob;
	
	@NotEmpty
	private String country;
	
	@Email
	@NotEmpty
	private String email;
	
	private List<Country> countriesList;
	
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Country> getCountriesList() {
		return countriesList;
	}
	public void setCountriesList(List<Country> countriesList) {
		this.countriesList = countriesList;
	}
	
}
