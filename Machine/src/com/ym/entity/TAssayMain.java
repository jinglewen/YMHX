package com.ym.entity;

import java.sql.Timestamp;

/**
 * TAssayMain entity. @author MyEclipse Persistence Tools
 */

public class TAssayMain implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer detectionType;
	private Integer createrId;
	private Timestamp creationTime;
	private Integer modifier;
	private Timestamp modifyTime;
	private String createrRealName;

	// Constructors

	/** default constructor */
	public TAssayMain() {
	}

	/** minimal constructor */
	public TAssayMain(String id, String name, Integer detectionType,
			Integer createrId, Timestamp creationTime, String createrRealName) {
		this.id = id;
		this.name = name;
		this.detectionType = detectionType;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.createrRealName = createrRealName;
	}

	/** full constructor */
	public TAssayMain(String id, String name, Integer detectionType,
			Integer createrId, Timestamp creationTime, Integer modifier,
			Timestamp modifyTime, String createrRealName) {
		this.id = id;
		this.name = name;
		this.detectionType = detectionType;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
		this.createrRealName = createrRealName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDetectionType() {
		return this.detectionType;
	}

	public void setDetectionType(Integer detectionType) {
		this.detectionType = detectionType;
	}

	public Integer getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getModifier() {
		return this.modifier;
	}

	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}

	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreaterRealName() {
		return this.createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}

}