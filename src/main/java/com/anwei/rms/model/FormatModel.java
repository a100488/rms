package com.anwei.rms.model;

import java.io.Serializable;
import java.util.Date;

public class FormatModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6544741632805205878L;
	private Double money;
	private Date date;
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
