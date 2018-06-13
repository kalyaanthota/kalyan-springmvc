package com.addressmodule.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "address")
public class useraddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addrid")
    private Integer addrid;
 
    @Column(name = "lane")
    private String lane;
 
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
	
    @Column(name = "pincode")
    private Integer pincode;
    
    @Column(name = "userid")
    private Integer userid;

	public Integer getAddrid() {
		return addrid;
	}

	public void setAddrid(Integer addrid) {
		this.addrid = addrid;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}


    
    
}