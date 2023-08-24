package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemExportDto {
  	private String processOrderCode;
  	private String materialCode;
  	private String postingDate;
  	private String plant;
  	private String farmCode;
  	private BigDecimal quantity;
  	private String unit;
  	private String batch;
  	private String barnCode;
  	
  	private String materialName;
  	private String manufacturedDate;
  	private String expiredDate;
	private String syncDate;
	
	private String prType;
	private String type;
	private String deliveryDate;
	private String note;
	private String createdDate;
	
	
	private String fromPlant;
	private String fromFarmCode;
	private String toPlant;
	private String toFarmCode;
	private String doCode;
	private String poCode;
	private String vendor;
	private String vendorName;
	private String transType;
	private BigDecimal grossWeight;
	private String weightUnit;
	private String materialType;
	
	private String customer;
  	private String customerName;
  	private String licensePlate;
  	private BigDecimal retained;
  	private BigDecimal amountEarlyStage;
  	private BigDecimal amountGoodsReceipt;
  	private BigDecimal amountGoodsIssue;
  	private BigDecimal amountFinalStage;
  	private String materialDesc;
  	private String materialNote;
}
