package com.gx.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 客户关系实现
 * @author win10
 *
 */
@Repository("QxDaoImpl")
public class QxDaoImpl {
	@Autowired(required=false)
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * 登陆
	 * @param name
	 * @param pass
	 * @return
	 */
	public List Login(String name,String pass){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT tu.`username`,tr.`name`,rp.`permission_insert`,rp.`permission_delete`, ");
		sb.append("rp.`permission_update`,rp.`permission_select`,uy.`ename`,tb.`ename` FROM user_role ur ");
		sb.append("INNER JOIN t_user tu ON ur.`user_id`=tu.`id` ");
		sb.append("INNER JOIN t_role tr ON ur.`role_id`=tr.`id` ");
		sb.append("INNER JOIN role_permission rp ON  tr.`id`=rp.`role_id` ");
		sb.append("INNER JOIN user_yuangong uy ON uy.`ur_id`=ur.`id` ");
		sb.append("INNER JOIN t_bm tb ON tb.`id`= uy.`tb_id` ");
		sb.append("WHERE tu.`username`=? AND tu.`password`=? FOR UPDATE");
		Object[] obj = {name,pass};
		List<Map<String,Object>> li = jdbcTemplate.queryForList(sb.toString(),obj);
		return li;
	}
	
	/**
	 * 所有员工信息
	 * @return
	 */
	public List StaffInfo(){
		StringBuffer Join = new StringBuffer();
		Join.append("SELECT uy.`id`,uy.`name`,tu.`username`,uy.`age`,uy.`sex`, ");
		Join.append("uy.`Email`,tb.`ename` FROM `user_yuangong` uy ");
		Join.append("INNER JOIN `user_role` ur ON ur.`id`=uy.`ur_id` ");
		Join.append("INNER JOIN `t_user` tu ON tu.id = ur_id ");
		Join.append("INNER JOIN `t_bm` tb ON tb.`id`=uy.`tb_id` ");
		List<Map<String,Object>> li = jdbcTemplate.queryForList(Join.toString());
		return li;
	}
	
	/**
	 * 提醒方法
	 * @return
	 */
	public List Remind(){
		String sql = "SELECT rd.`infotrme`,rd.`info`,uy.`ename` FROM remind rd "+
				"LEFT JOIN user_yuangong uy ON rd.`uy_id`=uy.`id`";
		List<Map<String,Object>> li = jdbcTemplate.queryForList(sql);
		return li;
	}
	
	/**
	 * 部门查询
	 * @return
	 */
	public List T_bm(){
		String sql = "SELECT tb.`id`,tb.`ename` FROM `t_bm` tb";
		List<Map<String,Object>> li = jdbcTemplate.queryForList(sql);
		return li;
	}
}
