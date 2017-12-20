package com.ym.entity;

/**
 * TDetectionItem2017 entity. @author MyEclipse Persistence Tools
 */

public class TDetectionItem2017 implements java.io.Serializable {

	// Fields

	private String id;
	private Integer assayType;
	private String result;
	private String detectionMainId;
	private String state;

	// Constructors

	/** default constructor */
	public TDetectionItem2017() {
	}

	/** full constructor */
	public TDetectionItem2017(String id, Integer assayType, String result,
			String detectionMainId, String state) {
		this.id = id;
		this.assayType = assayType;
		this.result = result;
		this.detectionMainId = detectionMainId;
		this.state = state;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAssayType() {
		return this.assayType;
	}

	public void setAssayType(Integer assayType) {
		this.assayType = assayType;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDetectionMainId() {
		return this.detectionMainId;
	}

	public void setDetectionMainId(String detectionMainId) {
		this.detectionMainId = detectionMainId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}