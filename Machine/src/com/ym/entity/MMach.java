package com.ym.entity;

/**
 * MMach entity. @author MyEclipse Persistence Tools
 */

public class MMach implements java.io.Serializable {

	// Fields

	private String serNumber;
	private String machName;
	private String machState;
	private String areaName;
	private String productDate;
	private String carnum;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public MMach() {
	}

	/** minimal constructor */
	public MMach(String serNumber) {
		this.serNumber = serNumber;
	}

	/** full constructor */
	public MMach(String serNumber, String machName, String machState,
			String areaName, String productDate, String carnum, Integer isDelete) {
		this.serNumber = serNumber;
		this.machName = machName;
		this.machState = machState;
		this.areaName = areaName;
		this.productDate = productDate;
		this.carnum = carnum;
		this.isDelete = isDelete;
	}

	// Property accessors

	public String getSerNumber() {
		return this.serNumber;
	}

	public void setSerNumber(String serNumber) {
		this.serNumber = serNumber;
	}

	public String getMachName() {
		return this.machName;
	}

	public void setMachName(String machName) {
		this.machName = machName;
	}

	public String getMachState() {
		return this.machState;
	}

	public void setMachState(String machState) {
		this.machState = machState;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getProductDate() {
		return this.productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getCarnum() {
		return this.carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}