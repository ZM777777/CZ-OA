package com.gx.entity;

/**
 * RolePermission entity. @author MyEclipse Persistence Tools
 */

public class RolePermission {

	// Fields

	private Integer id;
	private Integer roleId;
	private String permissionInsert;
	private String permissionDelete;
	private String permissionUpdate;
	private String permissionSelect;

	// Constructors

	/** default constructor */
	public RolePermission() {
	}

	/** full constructor */
	public RolePermission(Integer roleId, String permissionInsert,
			String permissionDelete, String permissionUpdate,
			String permissionSelect) {
		this.roleId = roleId;
		this.permissionInsert = permissionInsert;
		this.permissionDelete = permissionDelete;
		this.permissionUpdate = permissionUpdate;
		this.permissionSelect = permissionSelect;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getPermissionInsert() {
		return this.permissionInsert;
	}

	public void setPermissionInsert(String permissionInsert) {
		this.permissionInsert = permissionInsert;
	}

	public String getPermissionDelete() {
		return this.permissionDelete;
	}

	public void setPermissionDelete(String permissionDelete) {
		this.permissionDelete = permissionDelete;
	}

	public String getPermissionUpdate() {
		return this.permissionUpdate;
	}

	public void setPermissionUpdate(String permissionUpdate) {
		this.permissionUpdate = permissionUpdate;
	}

	public String getPermissionSelect() {
		return this.permissionSelect;
	}

	public void setPermissionSelect(String permissionSelect) {
		this.permissionSelect = permissionSelect;
	}

}