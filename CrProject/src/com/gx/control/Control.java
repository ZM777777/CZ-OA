package com.gx.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gx.logger.ServiceLogger;
import com.gx.serviceImpl.DlService;
import com.gx.serviceImpl.QxService;
import com.gx.util1.AppClass1;
import com.gx.util1.CallQuartz;

/**
 * 用户管理
 * @author win10
 *
 */
@Controller
public class Control{
	private QxService qxd = (QxService) AppClass1.getBanst("QxService");//用户管理
	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping("/Denglu_h")
	public String Denglu_h(String ename,String epass,Model model){
		DlService dl = (DlService) AppClass1.getBanst("S_Denglu");
		List<Map<String, Object>> li = dl.Denglu(ename,epass);
		if(li.size()<=0){
			model.addAttribute("error","登陆失败!");
			return "Login";
		}
		//权限单独分出来
		String[] temp = {(String) li.get(0).get("permission_insert"),(String) li.get(0).get("permission_delete"),
				(String) li.get(0).get("permission_update"),(String) li.get(0).get("permission_select")};
		ServiceLogger.ArrLi = temp;
		return "WEB-INF/jsp/index";
	}
	
	@RequestMapping("/Trime")
	public String Trime(String date1){
		String[] tem = date1.substring(0,10).split("-");//日期
		String[] tema = date1.substring(11).split(":");//时间
		CallQuartz.Quartz("00 "+tema[1]+" "+tema[0]+" "+tem[2]+" "+tem[1]+" ? "+tem[0]+"","");
		return "Login";
	}
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("/Clt")
	public String Clt(){
		DlService dl = (DlService) AppClass1.getBanst("S_Denglu");
		dl.Clt();//注销
		return "Login";
	}
	
	/**
	 * 部门信息加载
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/T_bm")
	public String T_bm(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Map<String,Object>> li = qxd.T_bm();
		for(Map<String, Object> map : li) {
			out.print("<tr>"+
					  "<td><input name='chks' value='26' type='checkbox'></td>"+
					  "<td>"+map.get("id")+"</td>"+
					  "<td>"+map.get("ename")+"</td>"+
					  "<td>"+
					  "<div class='am-btn-toolbar'>"+
					  "<div class='am-btn-group am-btn-group-xs'><button type='button' id='depart_26' class='am-btn am-btn-default am-btn-xs am-text-secondary btnedit'><span class='am-icon-pencil-square-o'></span> 编辑</button><button type='button' class='am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only' onclick='deleteDepart(26,1)'><span class='am-icon-trash-o'></span> 删除</button></div>"+
					  "</div>"+
					  "</td>"+
					  "</tr>"
					);
		}
		out.flush();
		out.close();
		return "depart";
	}
	
}
