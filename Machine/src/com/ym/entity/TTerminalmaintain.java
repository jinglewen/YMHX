package com.ym.entity;

/**
 * TTerminalmaintain entity. @author MyEclipse Persistence Tools
 */

public class TTerminalmaintain implements java.io.Serializable {

	// Fields

	private String id;
	private Integer createrId;
	private String creationTime;
	private Integer modifyId;
	private String modifyTime;
	private String boxNumber;
	private String wholeMachineId;
	private String createrRealName;
	private String updateRealName;
	private Integer boxState;
	private Integer wholeMachState;

	// Constructors

	/** default constructor */
	public TTerminalmaintain() {
	}

	/** minimal constructor */
	public TTerminalmaintain(String id, Integer createrId, String creationTime,
			String boxNumber, String wholeMachineId, String createrRealName) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.boxNumber = boxNumber;
		this.wholeMachineId = wholeMachineId;
		this.createrRealName = createrRealName;
	}

	/** full constructor */
	public TTerminalmaintain(String id, Integer createrId, String creationTime,
			Integer modifyId, String modifyTime, String boxNumber,
			String wholeMachineId, String createrRealName,
			String updateRealName, Integer boxState, Integer wholeMachState) {
		this.id = id;
		this.createrId = createrId;
		this.creationTime = creationTime;
		this.modifyId = modifyId;
		this.modifyTime = modifyTime;
		this.boxNumber = boxNumber;
		this.wholeMachineId = wholeMachineId;
		this.createrRealName = createrRealName;
		this.updateRealName = updateRealName;
		this.boxState = boxState;
		this.wholeMachState = wholeMachState;
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

	public String getBoxNumber() {
		return this.boxNumber;
	}

	public void setBoxNumber(String boxNumber) {
		this.boxNumber = boxNumber;
	}

	public String getWholeMachineId() {
		return this.wholeMachineId;
	}

	public void setWholeMachineId(String wholeMachineId) {
		this.wholeMachineId = wholeMachineId;
	}

	public String getCreaterRealName() {
		return this.createrRealName;
	}

	public void setCreaterRealName(String createrRealName) {
		this.createrRealName = createrRealName;
	}

	public String getUpdateRealName() {
		return this.updateRealName;
	}

	public void setUpdateRealName(String updateRealName) {
		this.updateRealName = updateRealName;
	}

	public Integer getBoxState() {
		return this.boxState;
	}

	public void setBoxState(Integer boxState) {
		this.boxState = boxState;
	}

	public Integer getWholeMachState() {
		return this.wholeMachState;
	}

	public void setWholeMachState(Integer wholeMachState) {
		this.wholeMachState = wholeMachState;
	}

}