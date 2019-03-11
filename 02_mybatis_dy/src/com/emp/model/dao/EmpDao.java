package com.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDao {

	List<Map> selectAll(SqlSession session);
	List<Map> selectSearch(SqlSession session, Map<String, String> map);
}
