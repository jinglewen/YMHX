package com.ym.entity;

/**
 * TIgonreconfig entity. @author MyEclipse Persistence Tools
 */

public class TIgonreconfig implements java.io.Serializable {

	// Fields

	private Integer id;
	private String key;
	private String remark;

	// Constructors

	/** default constructor */
	public TIgonreconfig() {
	}

	/** minimal constructor */
	public TIgonreconfig(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TIgonreconfig(Integer id, String key, String remark) {
		this.id = id;
		this.key = key;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}