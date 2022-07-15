package com.springrest.springrest.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springrest.springrest.validations.validation;

@Entity
public class Load implements validation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loadId;
	
	@Column(nullable=false)
	private String loadingPoint;
	@Column(nullable=false)
	private String unloadingPoint;
	@Column(nullable=false)
	private String productType;
	@Column(nullable=false)
	private String truckType;
	@Column(nullable=false)
	private String noOfTrucks;
	@Column(nullable=false)
	private String weight;
	private String comment;
	@Column(nullable=false)
	private String shipperId;
	@Column(nullable=false)
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;
	
	public Load(int loadId, String loadingPoint, String unloadingPoint, String productType, String truckType,
			    String noOfTrucks, String weight, String comment, String shipperId, Date date) {
		super();
		this.loadId = loadId;
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.comment = comment;
		this.shipperId = shipperId;
		this.date = date;
	}

	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLoadId() {
		return loadId;
	}

	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}

	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}
	
	public String getNoOfTrucks() {
		return noOfTrucks;
	}

	public void setNoOfTrucks(String noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getShipperId() {
		return shipperId;
	}

	public void setShipperId(String shipperId) {
		this.shipperId = shipperId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Load [loadId=" + loadId + ", loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint
				+ ", productType=" + productType + ", trucktype=" + truckType + ", noOfTrucks=" + noOfTrucks
				+ ", weight=" + weight + ", comment=" + comment + ", shipperId=" + shipperId + ", Date=" + date + "]";
	}

	@Override
	public void checkValidString(String value) {
		if(value == null || value.trim().length() < 1) {
			throw new RuntimeException("Not Setting a Valid String at "
									   + new Exception().getStackTrace()[1].getMethodName());
		}
	}
}
