package com.yc.biz;


import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

public interface SaleOrderBiz {

	/**
	 * 根据id查订单及它对应的订单详情
	 * @param id
	 * @return
	 */
	public SaleOrder getWithLines(Long id);

	public void add(SaleOrder o);

	public void addDetail(SaleOrderLine o);

	public void delOrderLine(SaleOrderLine saleOrderLine);
}
