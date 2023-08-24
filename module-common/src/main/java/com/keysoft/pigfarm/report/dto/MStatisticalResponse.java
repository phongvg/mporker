package com.keysoft.pigfarm.report.dto;

import lombok.Data;

@Data
public class MStatisticalResponse {
	
	private Integer errCode;
	
	private String errMessage;
	
	MStatisticalRequest result;
	
}
