package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleOrderLine;
import com.yc.bean.SaleProduct;
import com.yc.biz.SaleOrderBiz;

@Controller
@Scope(value="prototype")
public class SaleOrderLineController {

	@Resource(name="saleOrderBizImpl")
	private SaleOrderBiz saleOrderBiz;
	
	
	
	@RequestMapping("saleOrder_saveOrderLine.action")
	public String saveOrderLine(   SaleOrderLine saleOrderLine,HttpServletRequest request ){
		this.saleOrderBiz.addDetail(saleOrderLine);
		
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return "result";
	}
	
	
	@RequestMapping("saleOrder_delOrderLine.action")
	public String delOrderLine(   SaleOrderLine saleOrderLine,HttpServletRequest request ){
		this.saleOrderBiz.delOrderLine(saleOrderLine);
		
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return "result";
	}
}
