/*******************************************************************************
 *
 * Copyright ⓒ 2019 namu C&D corp. All rights reserved.
 *
 * This is a proprietary software of namu C&D corp, and you may not use this file except in
 * compliance with license agreement with namu C&D corp. Any redistribution or use of this
 * software, with or without modification shall be strictly prohibited without prior written
 * approval of namu C&D corp, and the copyright notice above does not evidence any actual or
 * intended publication of such software.
 *
 *******************************************************************************/
package com.anchordata.webframework.service.util;

public class UtilOccupationVO {

	
	//채용정보 - 희망지역
	private String master_id = "";
	private String category_id = "";
	private String occupation_cd = "";
	private String name = "";
	
	
	public String getMaster_id() {
		return master_id;
	}
	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getOccupation_cd() {
		return occupation_cd;
	}
	public void setOccupation_cd(String occupation_cd) {
		this.occupation_cd = occupation_cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
