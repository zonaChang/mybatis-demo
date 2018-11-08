package com.thinkive.dzjf.title.change.controller.basic.bean.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseBean implements Serializable{/*

	private Date createDate;

	private Date updateDate;

	protected void touchCreateTime() {
		this.createDate = new Date();
	}

	protected void touchUpdateTime() {
		this.updateDate = new Date();
	}

	@PrePersist
	public void fireCreated() {
		touchCreateTime();
		touchUpdateTime();
	}

	@PreUpdate
	public void fireUpdated() {
		touchUpdateTime();
	}
*/}
