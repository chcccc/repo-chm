package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.SaleProduct;
import com.yc.dao.CusCustomerDao;
import com.yc.dao.SaleProductDao;

@Repository
public class SaleProductDaoMybatisImpl implements SaleProductDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<SaleProduct> findAll() {
		return this.sqlSession.selectList("com.yc.dao.SaleProductDaoMapper.findAll");
	}
	
	

}
