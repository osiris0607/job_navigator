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
package com.anchordata.webframework.service.solar.online;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OnlineVO {

	private static final long serialVersionUID = 1L;

	private String online_id = "";
	private String url = "";
	private String title = "";
	private String writer = "";
	private String job_gb = "";
	private String video_tp_cd = "";
	private String upload_file_id = "";
	private String upload_file_name = "";
	private byte[] upload_file_image;
	private String file_name = "";
	private String reg_date = "";
	
	@JsonIgnore
	private MultipartFile attach_file;

	private int total_count;
	private int result;

	public String getOnline_id() {
		return online_id;
	}

	public void setOnline_id(String online_id) {
		this.online_id = online_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getJob_gb() {
		return job_gb;
	}

	public void setJob_gb(String job_gb) {
		this.job_gb = job_gb;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	public String getVideo_tp_cd() {
		return video_tp_cd;
	}

	public void setVideo_tp_cd(String video_tp_cd) {
		this.video_tp_cd = video_tp_cd;
	}
	
	public MultipartFile getAttach_file() {
		return attach_file;
	}

	public void setAttach_file(MultipartFile attach_file) {
		this.attach_file = attach_file;
	}

	public String getUpload_file_id() {
		return upload_file_id;
	}

	public void setUpload_file_id(String upload_file_id) {
		this.upload_file_id = upload_file_id;
	}

	public String getUpload_file_name() {
		return upload_file_name;
	}

	public void setUpload_file_name(String upload_file_name) {
		this.upload_file_name = upload_file_name;
	}

	public byte[] getUpload_file_image() {
		return upload_file_image;
	}

	public void setUpload_file_image(byte[] upload_file_image) {
		this.upload_file_image = upload_file_image;
	}
	
	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
