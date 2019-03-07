package com.mybatis.model.service;

import java.util.Map;

import com.mybatis.model.vo.Student;

public interface MybatisService {

	int insertStudent();
	int insertStudent(String name); // 오버로딩
	int insertStudent(Student s);
	int insertStudent(Map<String, Object> map);
	int selectCount();
}
