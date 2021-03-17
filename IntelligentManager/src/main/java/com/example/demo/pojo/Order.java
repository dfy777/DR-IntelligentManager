package com.example.demo.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994604583240811380L;
	private Integer order_id;
	private Integer fac_id;
	private Integer client_id;
	private String ord_name;
	private String description;
	private Date createtime;
	private Date finishtime;
	private Integer status;
	
	public Integer getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	public Integer getFac_id() {
		return fac_id;
	}
	
	public void setFac_id(Integer fac_id) {
		this.fac_id = fac_id;
	}
	
	public Integer getClient_id() {
		return client_id;
	}
	
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
	public String getOrd_name() {
		return ord_name;
	}
	public void setOrd_name(String ord_name) {
		this.ord_name = ord_name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreatetime() {
		return createtime;
	}
	
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Date getFinishtime() {
		return finishtime;
	}
	
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", fac_id=" + fac_id + ", client_id=" + client_id + ", ord_name="
				+ ord_name + ", description=" + description + ", createtime=" + createtime + ", finishtime="
				+ finishtime + ", status=" + status + "]";
	}
	
}
