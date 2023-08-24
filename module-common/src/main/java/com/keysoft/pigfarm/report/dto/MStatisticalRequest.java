package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class MStatisticalRequest {
	
	private BigDecimal sumFeed;
	
	private BigDecimal sumMedicine;
	
	private String stockCode;
	
	private String stage;

}
