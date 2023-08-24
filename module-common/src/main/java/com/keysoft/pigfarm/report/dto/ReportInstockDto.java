package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportInstockDto {
	private String materialCode;
	private String materialName;
	private String unit;
	private BigDecimal amountEarlyStage;
	private BigDecimal amountFinalStage;
	private BigDecimal amountGR;	// nhap
	private BigDecimal amountGA;	// xuat tieu hao
	private BigDecimal amountGI;	// xuat dieu chuyen
	
	// criteria
	private String stockCode;
	private String stage;
	
	private String fromDate;
	private String toDate;
	private String purchasingGroups;
}
