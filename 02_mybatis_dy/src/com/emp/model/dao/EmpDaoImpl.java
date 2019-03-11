package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {
	

	@Override
	public List<Map> selectAll(SqlSession session) {
		return session.selectList("emp.selectAll");
	}

	@Override
	public List<Map> selectSearch(SqlSession session, Map<String, String> map) {
		return session.selectList("emp.selectSearch", map);
	}

	
}
