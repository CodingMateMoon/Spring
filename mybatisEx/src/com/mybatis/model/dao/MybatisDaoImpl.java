package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public int insertTest(SqlSession session) {
		int result = session.insert("student.insertTest");
		return result;
	}

	@Override
	public List<Student> selectAllStudent(SqlSession session) {
		List<Student> list = session.selectList("student.selectAllStudent");
		return list;
	}

	@Override
	public List<Student> selectAllStudentMap(SqlSession session) {
		List<Student> list = session.selectList("student.selectAllStudentMap");
		return list;
	}

	@Override
	public List<Student> memberAll(SqlSession session) {
		List<Student> list = session.selectList("student.memberAll");
		return list;
	}

	@Override
	public List<Map> memberAllMap(SqlSession session) {
		return session.selectList("student.memberAllMap");
	}

	@Override
	public List<Map> memberSearch(SqlSession session, String keyword) {
		List<Map> list = session.selectList("student.memberSearch", keyword);
		return list;
	}
	
	
	

	
}
