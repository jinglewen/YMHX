package com.ym.entity;

/**
 * TAssayItem entity. @author MyEclipse Persistence Tools
 */

public class TAssayItem implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Integer assayType;
	private String fatherItemId;
	private String assatMainId;
	private Integer index;

	// Constructors

	/** default constructor */
	public TAssayItem() {
	}

	/** minimal constructor */
	public TAssayItem(String id, String name, Integer assayType,
			String assatMainId, Integer index) {
		this.id = id;
		this.name = name;
		this.assayType = assayType;
		this.assatMainId = assatMainId;
		this.index = index;
	}

	/** full constructor */
	public TAssayItem(String id, String name, Integer assayType,
			String fatherItemId, String assatMainId, Integer index) {
		this.id = id;
		this.name = name;
		this.assayType = assayType;
		this.fatherItemId = fatherItemId;
		this.assatMainId = assatMainId;
		this.index = index;
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

	public Integer getAssayType() {
		return this.assayType;
	}

	public void setAssayType(Integer assayType) {
		this.assayType = assayType;
	}

	public String getFatherItemId() {
		return this.fatherItemId;
	}

	public void setFatherItemId(String fatherItemId) {
		this.fatherItemId = fatherItemId;
	}

	public String getAssatMainId() {
		return this.assatMainId;
	}

	public void setAssatMainId(String assatMainId) {
		this.assatMainId = assatMainId;
	}

	public Integer getIndex() {
		return this.index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}