package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {
	

	@Override
	public List<Map> selectAll(SqlSession session) {
		return session.selectList("emp.selectAll");
	}

	@Override
	public List<Map> selectSearch(SqlSession session, Map<String, Object> map) {
		return session.selectList("emp.selectSearch", map);
	}

	@Override
	public int selectCount(SqlSession session) {
		return session.selectOne("emp.selectCount");
	}

	@Override
	public List<Map> selectPaging(SqlSession session, int cPage, int numPerPage) {
		RowBounds row = new RowBounds((cPage - 1) * numPerPage, numPerPage);
		return session.selectList("emp.selectPaging", null, row);
	}

	
}
