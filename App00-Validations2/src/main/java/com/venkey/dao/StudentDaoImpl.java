package com.venkey.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.venkey.bean.Country;
import com.venkey.bean.Gender;
import com.venkey.bean.StudentBean;
import com.venkey.mapper.CountryMapper;
@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Country> getAllCountries() {
		
		return jdbcTemplate.query("select * from countries", new CountryMapper());
	}

	@Override
	public boolean saveStudent(StudentBean studentBean) {
		String sid=studentBean.getStdId();
		String sname=studentBean.getStdName();
		int age=studentBean.getAge();
		Gender gender=studentBean.getGender();
		String genderValue="";
		if(gender==Gender.MALE) {
			genderValue="M";
		}
		else if (gender==Gender.FEMALE) {
			genderValue="F";
		}
		else {
			genderValue="OTH";
		}
		java.util.Date d1=studentBean.getDob();
		java.sql.Date dob=new java.sql.Date(d1.getTime());
		String email=studentBean.getEmail();
		String country=studentBean.getCountry();
		try {
			jdbcTemplate.update("insert into registered_Students values(?,?,?,?,?,?,?)", sid,sname,age,genderValue,dob,email,country);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
