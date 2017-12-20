package com.ym.entity;

/**
 * TDetectionvalueItem entity. @author MyEclipse Persistence Tools
 */

public class TDetectionvalueItem implements java.io.Serializable {

	// Fields

	private String id;
	private Integer assayType;
	private Double maxValue;
	private Double minValue;
	private String mainId;

	// Constructors

	/** default constructor */
	public TDetectionvalueItem() {
	}

	/** full constructor */
	public TDetectionvalueItem(String id, Integer assayType, Double maxValue,
			Double minValue, String mainId) {
		this.id = id;
		this.assayType = assayType;
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.mainId = mainId;
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

	public Double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public String getMainId() {
		return this.mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}

}