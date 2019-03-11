package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public interface MybatisDao {

	int insertTest(SqlSession session);
	List<Student> selectAllStudent(SqlSession session);
	List<Student> selectAllStudentMap(SqlSession session);
	List<Student> memberAll(SqlSession session);
	List<Map> memberAllMap(SqlSession session);
	List<Map> memberSearch(SqlSession session, String keyword);
}
