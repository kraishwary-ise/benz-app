package com.appn.Manager.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import com.example.benz.benz.Model.IncomingRequest;
import com.example.benz.benz.Model.Items;
import com.example.benz.benz.Model.ResponseBO;
@Service
public class Manager {

	public List<ResponseBO> createRequest(IncomingRequest ic) {
		System.out.println(ic.getPayload().get(0).getB());
		List<ResponseBO> rList=new ArrayList<>();
		int c=0;
		for(Items car:ic.getPayload()) {
			System.out.println(c);
			ResponseBO r=new ResponseBO();
			c+=1;
					
			r.setId(c);
			r.setDistance(Math.max(getMilageA(car),getDPSum(car)));
			rList.add(r);
		
		}
		
		return rList;
				
				
				
			
		}
	private Integer getDPSum(Items car) {
		int n=car.getN();
		ArrayList<Integer> capacity = (ArrayList<Integer>) car.getA().clone();
		
		ArrayList<Integer> milage = (ArrayList<Integer>) car.getB().clone();
		int K=car.getK();
		
		ArrayList<Integer> tempcapacity;
		ArrayList<Integer> tempmilage;
		HashMap<Integer, Integer>map=new HashMap<>();
		for(int i=0;i<n;i++) {
			
			tempcapacity=(ArrayList<Integer>) car.getA().clone();
			
			
			tempmilage=(ArrayList<Integer>) car.getB().clone();
			for(int j=0;j<i;j++) {
				
				Integer maxCapacity=Math.max(capacity.get(i),capacity.get(j));
				Integer minMilage=Math.min(milage.get(i),milage.get(j));
				tempcapacity.set(i, maxCapacity-K);
				tempcapacity.set(j, maxCapacity-K);
				tempmilage.set(i, minMilage);
				tempmilage.set(j, minMilage);
				Items newpayItems=new Items();
				newpayItems.setA(tempcapacity);
				newpayItems.setB(tempmilage);
				newpayItems.setN(n);
				map.put(i+1, getMilageA(newpayItems));
//				System.out.println( getMilageA(newpayItems));
		//		System.out.println( ic.getPayload().get(0).getA());

//				System.out.println(tempcapacity);
//								;
//				System.out.println(tempmilage);
	//tempcapacity.equals(ic.getPayload().get(0).getA());
//	System.out.println(ic.getPayload().get(0).getA());
//				
				
//				
				//System.out.println(maxCapacity+" "+minMilage);
			
			}
			
			
		}
	
		return Collections.max(map.values());
//;				Integer maxCap = Collections.max(ic.getPayload().get(0).getA());
//		Integer minMilage = Collections.min(ic.getPayload().get(0).getB());
//		//System.out.println(maxCap+" "+minMilage);
		
	
	}
	public Integer getMilageA(Items payload) {
		Integer milage=0;
		for(int i=0;i<payload.getN();i++) {
		//	System.out.println(milage+payload.getA().get(i)+" "+milage+payload.getB().get(i));
			 milage = milage+payload.getA().get(i)*payload.getB().get(i);
		}
	//	System.out.println(milage);
		
		return milage;
		
		// TODO Auto-generated method stub
		



}
	
}
