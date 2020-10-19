package com.venkey.dao;

import java.util.List;

import com.venkey.bean.Country;
import com.venkey.bean.StudentBean;

public interface StudentDao {
	List<Country> getAllCountries();
	boolean saveStudent(StudentBean studentBean);
}
