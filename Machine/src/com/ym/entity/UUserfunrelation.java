package com.ym.entity;

/**
 * UUserfunrelation entity. @author MyEclipse Persistence Tools
 */

public class UUserfunrelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer funId;

	// Constructors

	/** default constructor */
	public UUserfunrelation() {
	}

	/** minimal constructor */
	public UUserfunrelation(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public UUserfunrelation(Integer id, Integer userId, Integer funId) {
		this.id = id;
		this.userId = userId;
		this.funId = funId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFunId() {
		return this.funId;
	}

	public void setFunId(Integer funId) {
		this.funId = funId;
	}

}