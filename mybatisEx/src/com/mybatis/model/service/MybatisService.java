package com.mybatis.model.service;

import java.util.List;
import java.util.Map;

import com.mybatis.model.vo.Student;

public interface MybatisService {
	
	int insertTest();
	List<Student> selectAllStudent();
	List<Student> selectAllStudentMap();
	List<Student> memberAll();
	List<Map> memberAllMap();
	List<Map> memberSearch(String keyword);
}
