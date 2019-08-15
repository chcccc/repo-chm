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
import com.yc.biz.CusCustomerBiz;

@Controller
@Scope(value="prototype")
public class CusCustomerController {
	
		@Resource(name="cusCustomerBizImpl")
		private CusCustomerBiz cusCustomerBiz;
	

		@RequestMapping("cusCustomer_findAll.action")
		public String findAll(  HttpServletRequest request ) throws IOException {
			JsonModel jsonModel = new JsonModel();
			List<CusCustomer> list=this.cusCustomerBiz.findAll();
			jsonModel.setCode(1);
			jsonModel.setObj(  list   );  
			
			Gson gson=new Gson();
			String result=gson.toJson(jsonModel);
			
			request.setAttribute("jsonModel", result);
			return "result";
		}

}
