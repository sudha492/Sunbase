package com.tap.Dao;

import java.util.List;

import javax.servlet.ServletException;

import com.tap.Entity.StudentEntity;

public interface StudentDao {
	public boolean adddata(StudentEntity e) throws ServletException;
	public List<StudentEntity> getAllStudents() throws ServletException;
	public StudentEntity getStudentById(int id) throws ServletException;
	public boolean deleteStudentById(int id) throws ServletException;
		  }
