package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Rstudent;
import com.mybatis.model.vo.Student;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("student.insertStudent");
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, String name) {
		
		return session.insert("student.insertName", name);
	}

	@Override
	public int insertStudent(SqlSession session, Student s) {
		return session.insert("student.insertAll", s);
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> map) {
		return session.insert("student.insertMap", map);
	}

	@Override
	public int selectCount(SqlSession session) {
		return session.selectOne("student.selectCount");
	}

	@Override
	public Rstudent selectOne(SqlSession session, int no) {
		return session.selectOne("student.selectOne", no);
	}

	@Override
	public Map selectMap(SqlSession session, int no) {
		return session.selectOne("student.selectMap", no);
	}
	

/*	@Override
	public List<Rstudent> selectTotal(SqlSession session) {
		return session.selectList("student.selectTotal");
	}*/
	
	@Override
	public List selectTotal(SqlSession session) {
		return session.selectList("student.selectTotal");
	}

	@Override
	public List<Map<String, String>> selectTotalMap(SqlSession session) {
		return session.selectList("student.selectTotalMap");
	}

	@Override
	public int deleteStudent(SqlSession session, int no) {
		return session.delete("student.deleteStudent", no);
	}
	
	
	
	
	
	
}
