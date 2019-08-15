package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.CusCustomer;
import com.yc.dao.CusCustomerDao;

@Repository
public class CusCustomerDaoMybatisImpl implements CusCustomerDao {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<CusCustomer> findAll() {
		return this.sqlSession.selectList("com.yc.dao.CusCustomerDaoMapper.findAll");
	}
	
	

}
