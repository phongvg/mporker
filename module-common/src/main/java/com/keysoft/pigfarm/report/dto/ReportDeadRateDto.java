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
public class ReportDeadRateDto {
	private String processOrderCode;
	private String barnCode;
	private String barnName;
	private Integer totalPig;
	private BigDecimal totalPigDead;
	private BigDecimal rate;
	
	// criteria
	private String stockCode;
	private String stage;
}
