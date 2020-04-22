package com.wanghuadi.beans;

public class Hero {
	private Integer id;
	private String hname;
	private Double price;
	private Integer isHave;
	private String picurl;
	private Integer cid;
	private String cname;
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getIsHave() {
		return isHave;
	}
	public void setIsHave(Integer isHave) {
		this.isHave = isHave;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Hero(Integer id, String hname, Double price, Integer isHave, String picurl, Integer cid) {
		super();
		this.id = id;
		this.hname = hname;
		this.price = price;
		this.isHave = isHave;
		this.picurl = picurl;
		this.cid = cid;
	}
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Hero [id=" + id + ", hname=" + hname + ", price=" + price + ", isHave=" + isHave + ", picurl=" + picurl
				+ ", cid=" + cid + ", cname=" + cname + "]";
	}
	
}
