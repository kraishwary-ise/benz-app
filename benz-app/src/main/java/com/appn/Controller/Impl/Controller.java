package com.appn.Controller.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.appn.Manager.impl.Manager;
import com.example.benz.benz.Model.IncomingRequest;
import com.example.benz.benz.Model.Items;
import com.example.benz.benz.Model.ResponseBO;

import io.swagger.annotations.ApiOperation;
import twitter4j.JSONArray;
import twitter4j.JSONObject;

@RestController
public class Controller {
	
	 RestTemplate restTemplate = new RestTemplate();
		
		@Autowired
		private Manager manager;

		

		@PostMapping(value = "/mainApi/")
	    @ResponseBody
	    @ResponseStatus(code = HttpStatus.OK)
	    @ApiOperation(response = ResponseBO.class, value = "")
		public List<ResponseBO> getApi2(@RequestBody String params ) {
			
			JSONObject object = new JSONObject(params);
			IncomingRequest req=new IncomingRequest();
			
			Integer tc=Integer.parseInt(object.getString("Total Test Cases"));
			System.out.println(tc);
			List<Items> payLoads=new ArrayList<>();
			for(Integer i=1;i<=tc;i++) {
				Items payload=new Items();
				String incomingItem =  object.get(i.toString()).toString();
				JSONObject object2 = new JSONObject(incomingItem);
				int k=(int) object2.get("K");
				int n=(int) object2.get("N");
				payload.setK(k);
				payload.setN(n);
				System.out.println();
				ArrayList<Integer> A = new ArrayList<Integer>();     
				ArrayList<Integer> B = new ArrayList<Integer>();   
				JSONArray jArrayA = (JSONArray)object2.get("A"); 
				if (jArrayA != null) { 
				   for (int j=0;j<jArrayA.length();j++){ 
					   
				    A.add(Integer.parseInt(jArrayA.getString(j)));
				   } 
				} 
				JSONArray jArrayB = (JSONArray)object2.get("B"); 
				if (jArrayB != null) { 
				   for (int j=0;j<jArrayB.length();j++){ 
					   
				    B.add(Integer.parseInt(jArrayB.getString(j)));
				   } 
				}
				payload.setA(A);
				payload.setB(B);
				
				payLoads.add(payload);
			}
			
			
			
		
			req.setPayload(payLoads);
		  
		   return this.manager.createRequest(req);
			

		}
}
