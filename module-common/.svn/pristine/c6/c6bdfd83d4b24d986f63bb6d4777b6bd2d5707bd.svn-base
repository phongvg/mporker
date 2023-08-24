package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportPurchaseRequisitionDto {
	private String materialCode;
	private String materialName;
	private BigDecimal quantity;
	private BigDecimal retained; // so ton 
	private String unit;
	private LocalDate deliveryDate;
	private String description;
	private String note;
	private BigDecimal amountEarlyStage;
	private BigDecimal amountFinalStage;
	private BigDecimal amountGoodsReceipt;
	private BigDecimal amountGoodsAttrition;
	
	private String stockCode;
	
	private String deliveryFromDate;
	private String deliveryToDate;
	private String prType;
	private String purchasingGroup;
	
	public ReportPurchaseRequisitionDto(String materialCode, String materialName, BigDecimal quantity,
			BigDecimal retained, String unit, LocalDate deliveryDate, String description, String note,
			BigDecimal amountEarlyStage, BigDecimal amountFinalStage, BigDecimal amountGoodsReceipt,
			BigDecimal amountGoodsAttrition, String stockCode, String deliveryFromDate, String deliveryToDate, String prType,
			String purchasingGroup) {
		super();
		this.materialCode = materialCode;
		this.materialName = materialName;
		this.quantity = quantity;
		this.retained = retained;
		this.unit = unit;
		this.deliveryDate = deliveryDate;
		this.description = description;
		this.note = note;
		this.amountEarlyStage = BigDecimal.ZERO;
		this.amountFinalStage = BigDecimal.ZERO;
		this.amountGoodsReceipt = BigDecimal.ZERO;
		this.amountGoodsAttrition = BigDecimal.ZERO;
		this.stockCode = stockCode;
		this.deliveryFromDate = deliveryFromDate;
		this.deliveryToDate = deliveryToDate;
		this.prType = prType;
		this.purchasingGroup = purchasingGroup;
	}
	
	
}
