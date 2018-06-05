package com.gx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.daoimpl.QxDaoImpl;
import com.gx.inf.InfoFool;

/**
 * 中转类
 * @author win10
 *
 */
@Service("QxService")
public class QxService {
	/**
	 * 用户管理
	 */
	@Autowired(required=false)
	private QxDaoImpl qxd;
	public QxDaoImpl getQxd() {
		return qxd;
	}
	public void setQxd(QxDaoImpl qxd) {
		this.qxd = qxd;
	}
	
	/**
	 * 部门表
	 * @return
	 */
	@InfoFool
	public List T_bm(){
		return qxd.T_bm();
	}
}