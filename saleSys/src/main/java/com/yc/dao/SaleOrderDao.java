package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.type.JdbcType;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

//操作接口
public interface SaleOrderDao {

	/**
	 * 根据订单号查订单，包括订单项（集合)
	 * @param id
	 * @return
	 */
	public SaleOrder getWithLines(Long id);

	/**
	 * 添加订单
	 * @param o
	 */
	public void add(SaleOrder o);

	/**
	 * 添加订单详情<br />
	 * @param o
	 */
	public void addDetail(SaleOrderLine o);

	/**
	 * 更新订单详情.   (   主要是数量)
	 * @param o
	 */
	public void updateDatail(   SaleOrderLine o);
	/**
	 * 根据编号删除订单详情
	 * @param saleOrderLine
	 */
	public void delOrderLine(SaleOrderLine saleOrderLine);

}
