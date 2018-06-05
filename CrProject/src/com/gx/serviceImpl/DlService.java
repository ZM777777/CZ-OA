package com.gx.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.daoimpl.QxDaoImpl;
import com.gx.logger.ServiceLogger;

@Service("S_Denglu")
public class DlService {
	@Autowired(required=false)
	private QxDaoImpl qxd;
	public QxDaoImpl getQxd() {
		return qxd;
	}
	public void setQxd(QxDaoImpl qxd) {
		this.qxd = qxd;
	}
	/**
	 * 登陆
	 * @param ename
	 * @param epass
	 * @return
	 */
	public List Denglu(String ename,String epass){
		List<Map<String, Object>> li = qxd.Login(ename, epass);
		return li;
	}
	/**
	 * 注销
	 */
	public boolean Clt(){
		ServiceLogger.ArrLi = null;//权限注销
		if(ServiceLogger.ArrLi==null){
			return true;
		}else{
			return false;
		}
	}
}
