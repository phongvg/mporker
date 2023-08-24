package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SubReportVTDCDto {
	
	private String threeMonthAgo;
	private BigDecimal sumThreeMonthAgo;
	
	private String twoMonthAgo;
	private BigDecimal sumTwoMonthAgo;
	
	private String oneMonthAgo;
	private BigDecimal sumOneMonthAgo;
}
