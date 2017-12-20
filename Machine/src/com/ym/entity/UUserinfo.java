package com.ym.entity;

/**
 * UUserinfo entity. @author MyEclipse Persistence Tools
 */

public class UUserinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userName;
	private String passWord;
	private String realName;
	private String areaName;
	private String phone;
	private String email;
	private Integer isDelete;
	private Integer isEnable;
	private Integer userType;

	// Constructors

	/** default constructor */
	public UUserinfo() {
	}

	/** minimal constructor */
	public UUserinfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public UUserinfo(Integer id, String userName, String passWord,
			String realName, String areaName, String phone, String email,
			Integer isDelete, Integer isEnable, Integer userType) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.areaName = areaName;
		this.phone = phone;
		this.email = email;
		this.isDelete = isDelete;
		this.isEnable = isEnable;
		this.userType = userType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}