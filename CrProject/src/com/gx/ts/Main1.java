package com.gx.ts;

import java.util.List;
import java.util.Map;

import com.gx.serviceImpl.QxService;
import com.gx.util1.AppClass1;

public class Main1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QxService ctx = (QxService) AppClass1.getBanst("QxService");
		List<Map<String,Object>> li = ctx.T_bm();
		for (Map<String, Object> map : li) {
			System.out.println(map.get("id")+"\t"+map.get("ename"));
		}
	}
}
