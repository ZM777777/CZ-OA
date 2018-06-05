package com.gx.entity;

/**
 * TPermission entity. @author MyEclipse Persistence Tools
 */

public class TPermission {

	// Fields

	private Integer id;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public TPermission() {
	}

	/** minimal constructor */
	public TPermission(String name) {
		this.name = name;
	}

	/** full constructor */
	public TPermission(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}