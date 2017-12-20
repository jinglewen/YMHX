package com.ym.entity;

/**
 * TDetectionMain2018 entity. @author MyEclipse Persistence Tools
 */

public class TDetectionMain2018 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private String id;
	private String batchNumber;
	private Integer createrId;
	private String creationTime;
	private String result;
	private Integer detectionType;
	private String createrRealName;
	private String terminalModel;

	// Constructors

	/** default constructor */
	public TDetectionMain2018() {
	}

	/** minimal constructor */
	public TDetectionMain2018(String id, String batchNumber, Integer createrId,
			String creationTime, String result, Integer detectionType,
			String createrRealName) {
		this.id = id;
		this.batchNumber = batchNumber;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.result = result;
		this.detectionType = detectionType;
		this.createrRealName = createrRealName;
	}

	/** full constructor */
	public TDetectionMain2018(String id, String batchNumber, Integer createrId,
			String creationTime, String result, Integer detectionType,
			String createrRealName, String terminalModel) {
		this.id = id;
		this.batchNumber = batchNumber;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.result = result;
		this.detectionType = detectionType;
		this.createrRealName = createrRealName;
		this.terminalModel = terminalModel;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Integer getCreaterId() {
		return this.createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	public String getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getDetectionType() {
		return this.detectionType;
	}

	public void setDetectionType(Integer detectionType) {
		this.detectionType = detectionType;
	}

	public String getCreaterRealName() {
		return this.createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}

	public String getTerminalModel() {
		return this.terminalModel;
	}

	public void setTerminalModel(String terminalModel) {
		this.terminalModel = terminalModel;
	}

}