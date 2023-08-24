package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportADGDto {
	private String barnCode;
	private String barnName;
	
	private String fromDate;
	private Integer amountEarlyPig;
	private BigDecimal amountEarlyWeight;
	private BigDecimal averageEarly;
	
	private String toDate;
	private Integer amountFinalPig;
	private BigDecimal amountFinalWeight;
	private BigDecimal averageFinal;
	
	private BigDecimal adgIndex;
	
	private String stockCode;
	private String stage;
	private String poCode;

	public ReportADGDto() {
		super();
		this.barnCode = "";
		this.barnName = "";
		this.amountEarlyPig = 0;
		this.amountEarlyWeight = BigDecimal.ZERO;
		this.averageEarly = BigDecimal.ZERO;
		this.amountFinalPig = 0;
		this.amountFinalWeight = BigDecimal.ZERO;
		this.averageFinal = BigDecimal.ZERO;
		this.adgIndex = BigDecimal.ZERO;;
	}
	
}
