package com.ym.entity;

import java.sql.Timestamp;

/**
 * TTerminaldefaultconfig entity. @author MyEclipse Persistence Tools
 */

public class TTerminaldefaultconfig implements java.io.Serializable {

	// Fields

	private String id;
	private Integer createrId;
	private Timestamp creationTime;
	private Integer modifier;
	private Timestamp modifyTime;
	private String createrRealName;
	private String terminalModel;
	private String version;
	private String content;
	private Integer deliveryObjectCode;

	// Constructors

	/** default constructor */
	public TTerminaldefaultconfig() {
	}

	/** minimal constructor */
	public TTerminaldefaultconfig(String id, Integer createrId,
			Timestamp creationTime, String createrRealName,
			String terminalModel, String version, String content,
			Integer deliveryObjectCode) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.createrRealName = createrRealName;
		this.terminalModel = terminalModel;
		this.version = version;
		this.content = content;
		this.deliveryObjectCode = deliveryObjectCode;
	}

	/** full constructor */
	public TTerminaldefaultconfig(String id, Integer createrId,
			Timestamp creationTime, Integer modifier, Timestamp modifyTime,
			String createrRealName, String terminalModel, String version,
			String content, Integer deliveryObjectCode) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
		this.createrRealName = createrRealName;
		this.terminalModel = terminalModel;
		this.version = version;
		this.content = content;
		this.deliveryObjectCode = deliveryObjectCode;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTerminalModel() {
		return this.terminalModel;
	}

	public void setTerminalModel(String terminalModel) {
		this.terminalModel = terminalModel;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDeliveryObjectCode() {
		return this.deliveryObjectCode;
	}

	public void setDeliveryObjectCode(Integer deliveryObjectCode) {
		this.deliveryObjectCode = deliveryObjectCode;
	}

}