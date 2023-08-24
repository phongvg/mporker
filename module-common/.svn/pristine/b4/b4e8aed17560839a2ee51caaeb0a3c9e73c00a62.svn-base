package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BarnReportDto {
	
	private String barnCode;
	private String barnName;
	private String startDate;
	private String receiveFarm; // trai nguon
	private Integer totalPig;
	private String pigType;
	private BigDecimal totalEntryVolumn;
	private BigDecimal averageVolumn;
	private Integer ageWeek;
	private Integer amountEarlyStage; // ton dau ky
	private Integer amountFinalStage; // ton cuoi ky
	private List<BarnContentDto> contents;
}
