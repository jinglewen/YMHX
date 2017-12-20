package com.ym.entity;

/**
 * TTerminalassembly entity. @author MyEclipse Persistence Tools
 */

public class TTerminalassembly implements java.io.Serializable {

	// Fields

	private String id;
	private Integer createrId;
	private String creationTime;
	private String posModuleId;
	private String communicationModuleId;
	private String pcbmoduleId;
	private String wifiModuleId;
	private String wholeMachineModuleId;
	private String createrRealName;
	private Integer modifyId;
	private String modifyTime;

	// Constructors

	/** default constructor */
	public TTerminalassembly() {
	}

	/** minimal constructor */
	public TTerminalassembly(String id, Integer createrId, String creationTime,
			String createrRealName) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.createrRealName = createrRealName;
	}

	/** full constructor */
	public TTerminalassembly(String id, Integer createrId, String creationTime,
			String posModuleId, String communicationModuleId,
			String pcbmoduleId, String wifiModuleId,
			String wholeMachineModuleId, String createrRealName,
			Integer modifyId, String modifyTime) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.posModuleId = posModuleId;
		this.communicationModuleId = communicationModuleId;
		this.pcbmoduleId = pcbmoduleId;
		this.wifiModuleId = wifiModuleId;
		this.wholeMachineModuleId = wholeMachineModuleId;
		this.createrRealName = createrRealName;
		this.modifyId = modifyId;
		this.modifyTime = modifyTime;
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

	public String getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getPosModuleId() {
		return this.posModuleId;
	}

	public void setPosModuleId(String posModuleId) {
		this.posModuleId = posModuleId;
	}

	public String getCommunicationModuleId() {
		return this.communicationModuleId;
	}

	public void setCommunicationModuleId(String communicationModuleId) {
		this.communicationModuleId = communicationModuleId;
	}

	public String getPcbmoduleId() {
		return this.pcbmoduleId;
	}

	public void setPcbmoduleId(String pcbmoduleId) {
		this.pcbmoduleId = pcbmoduleId;
	}

	public String getWifiModuleId() {
		return this.wifiModuleId;
	}

	public void setWifiModuleId(String wifiModuleId) {
		this.wifiModuleId = wifiModuleId;
	}

	public String getWholeMachineModuleId() {
		return this.wholeMachineModuleId;
	}

	public void setWholeMachineModuleId(String wholeMachineModuleId) {
		this.wholeMachineModuleId = wholeMachineModuleId;
	}

	public String getCreaterRealName() {
		return this.createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}

	public Integer getModifyId() {
		return this.modifyId;
	}

	public void setModifyId(Integer modifyId) {
		this.modifyId = modifyId;
	}

	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}