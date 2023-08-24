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
public class ReportGoodsReceiptDto {
	
	private LocalDate postingDate;
	private String materialCode;
	private String materialName;
	private String unit;
	private BigDecimal amount;
	private String type;
	private String fromStockCode;
	private String batch;
	
	// criteria
	private String stockCode;
	private String stage;
	private String fromDate;
	private String toDate;
	private String purchasingGroups;

}
