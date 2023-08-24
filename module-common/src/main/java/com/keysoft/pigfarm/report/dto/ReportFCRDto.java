package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportFCRDto {
	private String barnCode;
	private String barnName;
	private Integer amountEarlyPig;
	private BigDecimal amountEarlyWeight;
	private BigDecimal averageEarly;
	
	private Integer amountFinalPig;
	private BigDecimal amountFinalWeight;
	private BigDecimal averageFinal;
	
	private BigDecimal sumAmountFeed;
	private BigDecimal fcrReality;
	private BigDecimal fcrStandard;
	private BigDecimal fcrRange;
	
	// criteria
	private String stockCode;
	private String stage;
	private String poCode;
	
	public ReportFCRDto() {
		super();
		this.barnCode = "";
		this.barnName = "";
		this.amountEarlyPig = 0;
		this.amountEarlyWeight = BigDecimal.ZERO;
		this.averageEarly = BigDecimal.ZERO;
		this.amountFinalPig = 0;
		this.amountFinalWeight = BigDecimal.ZERO;
		this.averageFinal = BigDecimal.ZERO;
		this.sumAmountFeed = BigDecimal.ZERO;
		this.fcrReality = BigDecimal.ZERO;
		this.fcrStandard = BigDecimal.ZERO;
		this.fcrRange = BigDecimal.ZERO;
	}
	
}
