package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;
import com.yc.dao.SaleOrderDao;

@Service
@Transactional(readOnly = false, isolation = Isolation.DEFAULT, rollbackForClassName = {
		"java.lang.RuntimeException" }, propagation = Propagation.REQUIRED)
public class SaleOrderBizImpl implements SaleOrderBiz {
	private SaleOrderDao saleOrderDao;

	@Transactional(readOnly = true)
	public SaleOrder getWithLines(Long id) {
		return this.saleOrderDao.getWithLines(id);
	}
	

	public void add(SaleOrder o) {
		this.saleOrderDao.add(o);
	}

	public void addDetail(SaleOrderLine o) {
		boolean flag=false;
		//1. 根据   订单编号查订单，以获得这个订单的订单详情.
		SaleOrder so=getWithLines(  o.getSaleOrder().getOdrId() );
		//有详情，则看详情中的产品是否是当前这个  要下订的产品，如果是，则加数量。 
		if(   so!=null&& so.getSaleOrderLines()!=null&& so.getSaleOrderLines().size()>0 ){
			List<SaleOrderLine> list=so.getSaleOrderLines();
			for(  SaleOrderLine sol:list){
				if(  sol.getOdlProductName().equals(o.getOdlProductName())){
					//如果产品已经存在，则取出订单详情编号，及更改数量
					o.setOdlId(   sol.getOdlId() );
					o.setOdlProductCount(   o.getOdlProductCount()+sol.getOdlProductCount() );
					flag=true;
					break;
				}
			}
		}
		if( flag){
			this.saleOrderDao.updateDatail(o);
		}else{
			this.saleOrderDao.addDetail(o);
		}
	}

	public void delOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderDao.delOrderLine(saleOrderLine);
	}

	@Resource(name = "saleOrderDaoMybatisImpl")
	public void setSaleOrderDao(SaleOrderDao saleOrderDao) {
		this.saleOrderDao = saleOrderDao;
	}

}
