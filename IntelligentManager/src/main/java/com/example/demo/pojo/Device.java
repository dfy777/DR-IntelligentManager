package com.example.demo.pojo;

import java.io.Serializable;

public class Device implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2885733896240232659L;
	
	private Integer cid;
	private Integer fac_id;
	private Integer dev_id;
	private Integer ord_id;
	private Integer client_id;
	private Integer prod_id;
	private Integer prod_num;
	private Integer dev_num;
	private String ordname;
	private String status;
	private String devname;
	private String prodname;
	private Integer progress;
	
	
	public Device(String devname, int devnum, int devid) {
		this.dev_id = devid;
		this.dev_num = devnum;
		this.devname = devname;
		
		this.status = "未运行";
		this.progress = 0;
	}
	
	
	public Integer getCid() {
		return cid;
	}
	
	
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	
	public Integer getFac_id() {
		return fac_id;
	}
	
	
	public void setFac_id(Integer fac_id) {
		this.fac_id = fac_id;
	}
	
	
	public void setFacId(Integer fac_id) {
		this.fac_id = fac_id;
	}
	
	
	public Integer getDev_id() {
		return dev_id;
	}
	
	
	public void setDev_id(Integer dev_id) {
		this.dev_id = dev_id;
	}
	
	
	public void setDevId(Integer dev_id) {
		this.dev_id = dev_id;
	}
	
	
	public Integer getOrd_id() {
		return ord_id;
	}
	
	
	public void setOrd_id(Integer ord_id) {
		this.ord_id = ord_id;
	}
	
	public void setOrdId(Integer ord_id) {
		this.ord_id = ord_id;
	}
	
	
	public Integer getProd_id() {
		return prod_id;
	}
	
	
	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}
	
	public void setProdId(Integer prod_id) {
		this.prod_id = prod_id;
	}
	
	
	public Integer getProd_num() {
		return prod_num;
	}
	
	
	public void setProd_num(Integer prod_num) {
		this.prod_num = prod_num;
	}
	
	
	public void setProdNum(Integer prod_num) {
		this.prod_num = prod_num;
	}
	
	
	public Integer getDev_num() {
		return dev_num;
	}
	
	
	public void setDev_num(Integer dev_num) {
		this.dev_num = dev_num;
	}
	
	public void setDevNum(Integer dev_num) {
		this.dev_num = dev_num;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getDevname() {
		return devname;
	}
	
	
	public void setDevname(String devname) {
		this.devname = devname;
	}
	
	
	public String getProdname() {
		return prodname;
	}
	
	
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	
	
	public Integer getProgress() {
		return progress;
	}
	
	
	public void setProgress(Integer progress) {
		this.progress = progress;
	}


	@Override
	public String toString() {
		return "Device [cid=" + cid + ", fac_id=" + fac_id + ", dev_id=" + dev_id + ", ord_id=" + ord_id + ", prod_id="
				+ prod_id + ", prod_num=" + prod_num + ", dev_num=" + dev_num + ", status=" + status + ", devname="
				+ devname + ", prodname=" + prodname + ", progress=" + progress + "]";
	}


	public String getOrdname() {
		return ordname;
	}


	public void setOrdname(String ordname) {
		this.ordname = ordname;
	}


	public Integer getClient_id() {
		return client_id;
	}


	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
	
	public void setClientId(Integer client_id) {
		this.client_id = client_id;
	}
}
