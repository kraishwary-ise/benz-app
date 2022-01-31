package com.example.benz.benz.Model;


import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Items {
	
	private  Integer n;
	private  ArrayList<Integer> a;
	private  ArrayList<Integer> b;
	private  Integer k;
	/**
	 * @return the n
	 */
	public Integer getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(Integer n) {
		this.n = n;
	}
	/**
	 * @return the a
	 */
	public ArrayList<Integer> getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(ArrayList<Integer> a) {
		this.a = a;
	}
	/**
	 * @return the b
	 */
	public ArrayList<Integer> getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(ArrayList<Integer> b) {
		this.b = b;
	}
	/**
	 * @return the k
	 */
	public Integer getK() {
		return k;
	}
	/**
	 * @param k the k to set
	 */
	public void setK(Integer k) {
		this.k = k;
	}
	
	

}
