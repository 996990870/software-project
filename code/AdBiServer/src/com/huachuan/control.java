package com.huachuan;
import java.io.File;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.ResultSet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
@Controller

@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", origins = "*")
public class control {
	
	
	@RequestMapping(value="/loginjudge",produces="application/json;charset=utf-8")
	   public @ResponseBody String checklogin(@RequestParam("username") String username,@RequestParam("password") String password) {
		boolean rs=false;
	
		  System.out.println(username);
		try {
			rs = SqlHelper.checkinfo(username, password);
			System.out.print(rs);
			 if(rs) {
				  return"{\"judgeresult\":\"��½�ɹ�\"}";
			  }
			 else {
				  return"{\"judgeresult\":\"��½ʧ��\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"��½ʧ��\"}";
		  
		   
		   
	   }

	
	@RequestMapping(value="/loginregister",produces="application/json;charset=utf-8")
	   public @ResponseBody String loginregister(@RequestParam("username") String username,@RequestParam("password") String password) {
		  boolean rs=false;
		  System.out.println(username+"ע���С�������");
		  
		try {
			rs = SqlHelper.register(username, password);
			 if(rs) {
				 
				  return"{\"judgeresult\":\"ע��ɹ�\"}";
			  }
			 else {
				  System.out.println("ע��ʧ�ܣ�����");
				  return"{\"judgeresult\":\"ע��ʧ��\"}";
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			  return"{\"judgeresult\":\"ע��ʧ��\"}";
		  
		   
		   
	   }
	
	

	@RequestMapping(value="/querybook",produces="application/json;charset=utf-8")
	   public @ResponseBody String bookquery(@RequestParam("class") String classification) {
		 
		 return SqlHelper.querybook(classification);
		 
		  
		   
		   
	   }
	
}
