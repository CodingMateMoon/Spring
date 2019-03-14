package com.kh.spring.dao;

import java.util.List;

import com.kh.spring.model.vo.Dev;

public interface DomoDao {
	void print();
	
	int insert(Dev dev);
	Dev select(int num);
	List<Dev> selectList();
}
