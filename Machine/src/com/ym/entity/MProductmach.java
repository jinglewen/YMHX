package com.ym.entity;

/**
 * MProductmach entity. @author MyEclipse Persistence Tools
 */

public class MProductmach implements java.io.Serializable {

	// Fields

	private Integer id;
	private String serNumber;
	private String machName;
	private String machState;
	private String areaName;
	private String terminalId;
	private String manufacturerId;
	private String detectionId;
	private String psModuleId;
	private String psModule;
	private String phModuleId;
	private String phModule;
	private String hardwareversion;
	private String softwareversion;
	private String mainnetIp1;
	private String mainnetIp2;
	private String mainnetIp3;
	private String secondnetIp1;
	private String secondnetIp2;
	private String secondnetIp3;
	private String tcpprot1;
	private String tcpprot2;
	private String tcpprot3;
	private String udpprot1;
	private String udpprot2;
	private String udpprot3;
	private String phoneModel1;
	private String phoneMode2;
	private String phoneModel3;
	private String carplateNum;
	private String carplateColor;
	private String simcard;
	private String provinceId;
	private String apnname;
	private String apnuserName;
	private String apnpassWrod;
	private String cityId;
	private String productDate;
	private String productUserName;
	private String productUserPhone;
	private String operator;
	private String optime;
	private Integer isDelete;
	private String remark;

	// Constructors

	/** default constructor */
	public MProductmach() {
	}

	/** minimal constructor */
	public MProductmach(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public MProductmach(Integer id, String serNumber, String machName,
			String machState, String areaName, String terminalId,
			String manufacturerId, String detectionId, String psModuleId,
			String psModule, String phModuleId, String phModule,
			String hardwareversion, String softwareversion, String mainnetIp1,
			String mainnetIp2, String mainnetIp3, String secondnetIp1,
			String secondnetIp2, String secondnetIp3, String tcpprot1,
			String tcpprot2, String tcpprot3, String udpprot1, String udpprot2,
			String udpprot3, String phoneModel1, String phoneMode2,
			String phoneModel3, String carplateNum, String carplateColor,
			String simcard, String provinceId, String apnname,
			String apnuserName, String apnpassWrod, String cityId,
			String productDate, String productUserName,
			String productUserPhone, String operator, String optime,
			Integer isDelete, String remark) {
		this.id = id;
		this.serNumber = serNumber;
		this.machName = machName;
		this.machState = machState;
		this.areaName = areaName;
		this.terminalId = terminalId;
		this.manufacturerId = manufacturerId;
		this.detectionId = detectionId;
		this.psModuleId = psModuleId;
		this.psModule = psModule;
		this.phModuleId = phModuleId;
		this.phModule = phModule;
		this.hardwareversion = hardwareversion;
		this.softwareversion = softwareversion;
		this.mainnetIp1 = mainnetIp1;
		this.mainnetIp2 = mainnetIp2;
		this.mainnetIp3 = mainnetIp3;
		this.secondnetIp1 = secondnetIp1;
		this.secondnetIp2 = secondnetIp2;
		this.secondnetIp3 = secondnetIp3;
		this.tcpprot1 = tcpprot1;
		this.tcpprot2 = tcpprot2;
		this.tcpprot3 = tcpprot3;
		this.udpprot1 = udpprot1;
		this.udpprot2 = udpprot2;
		this.udpprot3 = udpprot3;
		this.phoneModel1 = phoneModel1;
		this.phoneMode2 = phoneMode2;
		this.phoneModel3 = phoneModel3;
		this.carplateNum = carplateNum;
		this.carplateColor = carplateColor;
		this.simcard = simcard;
		this.provinceId = provinceId;
		this.apnname = apnname;
		this.apnuserName = apnuserName;
		this.apnpassWrod = apnpassWrod;
		this.cityId = cityId;
		this.productDate = productDate;
		this.productUserName = productUserName;
		this.productUserPhone = productUserPhone;
		this.operator = operator;
		this.optime = optime;
		this.isDelete = isDelete;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getManufacturerId() {
		return this.manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getDetectionId() {
		return this.detectionId;
	}

	public void setDetectionId(String detectionId) {
		this.detectionId = detectionId;
	}

	public String getPsModuleId() {
		return this.psModuleId;
	}

	public void setPsModuleId(String psModuleId) {
		this.psModuleId = psModuleId;
	}

	public String getPsModule() {
		return this.psModule;
	}

	public void setPsModule(String psModule) {
		this.psModule = psModule;
	}

	public String getPhModuleId() {
		return this.phModuleId;
	}

	public void setPhModuleId(String phModuleId) {
		this.phModuleId = phModuleId;
	}

	public String getPhModule() {
		return this.phModule;
	}

	public void setPhModule(String phModule) {
		this.phModule = phModule;
	}

	public String getHardwareversion() {
		return this.hardwareversion;
	}

	public void setHardwareversion(String hardwareversion) {
		this.hardwareversion = hardwareversion;
	}

	public String getSoftwareversion() {
		return this.softwareversion;
	}

	public void setSoftwareversion(String softwareversion) {
		this.softwareversion = softwareversion;
	}

	public String getMainnetIp1() {
		return this.mainnetIp1;
	}

	public void setMainnetIp1(String mainnetIp1) {
		this.mainnetIp1 = mainnetIp1;
	}

	public String getMainnetIp2() {
		return this.mainnetIp2;
	}

	public void setMainnetIp2(String mainnetIp2) {
		this.mainnetIp2 = mainnetIp2;
	}

	public String getMainnetIp3() {
		return this.mainnetIp3;
	}

	public void setMainnetIp3(String mainnetIp3) {
		this.mainnetIp3 = mainnetIp3;
	}

	public String getSecondnetIp1() {
		return this.secondnetIp1;
	}

	public void setSecondnetIp1(String secondnetIp1) {
		this.secondnetIp1 = secondnetIp1;
	}

	public String getSecondnetIp2() {
		return this.secondnetIp2;
	}

	public void setSecondnetIp2(String secondnetIp2) {
		this.secondnetIp2 = secondnetIp2;
	}

	public String getSecondnetIp3() {
		return this.secondnetIp3;
	}

	public void setSecondnetIp3(String secondnetIp3) {
		this.secondnetIp3 = secondnetIp3;
	}

	public String getTcpprot1() {
		return this.tcpprot1;
	}

	public void setTcpprot1(String tcpprot1) {
		this.tcpprot1 = tcpprot1;
	}

	public String getTcpprot2() {
		return this.tcpprot2;
	}

	public void setTcpprot2(String tcpprot2) {
		this.tcpprot2 = tcpprot2;
	}

	public String getTcpprot3() {
		return this.tcpprot3;
	}

	public void setTcpprot3(String tcpprot3) {
		this.tcpprot3 = tcpprot3;
	}

	public String getUdpprot1() {
		return this.udpprot1;
	}

	public void setUdpprot1(String udpprot1) {
		this.udpprot1 = udpprot1;
	}

	public String getUdpprot2() {
		return this.udpprot2;
	}

	public void setUdpprot2(String udpprot2) {
		this.udpprot2 = udpprot2;
	}

	public String getUdpprot3() {
		return this.udpprot3;
	}

	public void setUdpprot3(String udpprot3) {
		this.udpprot3 = udpprot3;
	}

	public String getPhoneModel1() {
		return this.phoneModel1;
	}

	public void setPhoneModel1(String phoneModel1) {
		this.phoneModel1 = phoneModel1;
	}

	public String getPhoneMode2() {
		return this.phoneMode2;
	}

	public void setPhoneMode2(String phoneMode2) {
		this.phoneMode2 = phoneMode2;
	}

	public String getPhoneModel3() {
		return this.phoneModel3;
	}

	public void setPhoneModel3(String phoneModel3) {
		this.phoneModel3 = phoneModel3;
	}

	public String getCarplateNum() {
		return this.carplateNum;
	}

	public void setCarplateNum(String carplateNum) {
		this.carplateNum = carplateNum;
	}

	public String getCarplateColor() {
		return this.carplateColor;
	}

	public void setCarplateColor(String carplateColor) {
		this.carplateColor = carplateColor;
	}

	public String getSimcard() {
		return this.simcard;
	}

	public void setSimcard(String simcard) {
		this.simcard = simcard;
	}

	public String getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getApnname() {
		return this.apnname;
	}

	public void setApnname(String apnname) {
		this.apnname = apnname;
	}

	public String getApnuserName() {
		return this.apnuserName;
	}

	public void setApnuserName(String apnuserName) {
		this.apnuserName = apnuserName;
	}

	public String getApnpassWrod() {
		return this.apnpassWrod;
	}

	public void setApnpassWrod(String apnpassWrod) {
		this.apnpassWrod = apnpassWrod;
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProductDate() {
		return this.productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductUserName() {
		return this.productUserName;
	}

	public void setProductUserName(String productUserName) {
		this.productUserName = productUserName;
	}

	public String getProductUserPhone() {
		return this.productUserPhone;
	}

	public void setProductUserPhone(String productUserPhone) {
		this.productUserPhone = productUserPhone;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOptime() {
		return this.optime;
	}

	public void setOptime(String optime) {
		this.optime = optime;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}