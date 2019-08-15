package com.yc.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yc.bean.CusCustomer;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleOrder;
import com.yc.biz.SaleOrderBiz;

@Controller
@Scope(value="prototype")
public class SaleOrderController {
	
	@Resource(name="saleOrderBizImpl")
	private SaleOrderBiz saleOrderBiz;

	
	@RequestMapping("saleOrder_save.action")
	public String findAll(   SaleOrder saleOrder,HttpServletRequest request ) throws IOException {
		JsonModel jsonModel = new JsonModel();

		this.saleOrderBiz.add(  saleOrder     );
		long odrId=saleOrder.getOdrId();

		jsonModel.setCode(1);
		jsonModel.setObj(  odrId   );  
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return "result";
	}
	
	
	@RequestMapping("saleOrder_findOrderWithDetail.action")
	public String findOrderWithDetail(  long odrId,HttpServletRequest request ) throws IOException {
		JsonModel jsonModel = new JsonModel();

		SaleOrder saleOrder=this.saleOrderBiz.getWithLines(odrId);
	
		jsonModel.setCode(1);
		jsonModel.setObj(  saleOrder   );  
		
		Gson gson=new Gson();
		String result=gson.toJson(jsonModel);
		
		request.setAttribute("jsonModel", result);
		return "result";
	}
}
