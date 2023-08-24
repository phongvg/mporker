package com.keysoft.pigfarm.report.dto;

import java.util.List;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportDayDto {

	private String farmCode;
	private String farmName;
	private List<BarnReportDto> barnReports;
	
}
