package com.kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.vo.Dev;

@Repository
public class DomoDaoImpl implements DomoDao {
	
	@Autowired
	private SqlSessionTemplate session;

	@Override
	public void print() {

		System.out.println("DAO");
	}

	@Override
	public int insert(Dev dev) {
		// TODO Auto-generated method stub
		return session.insert("dev.insert", dev);
	}

	@Override
	public Dev select(int num) {
		return session.selectOne("dev.select", num);
	}

	@Override
	public List<Dev> selectList() {
		return session.selectList("dev.selectList");
	}

	
	
}
