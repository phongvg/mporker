package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportVTDCDto {
	private String materialCode;
	private String materialName;
	private String unit;
	
	private SubReportVTDCDto subReportVTDC;
	
	private BigDecimal amountFinalBeforeStage; // ton cuoi ky thang trc
	private BigDecimal quantity; // so luong mua ky chon
	private String note;  // mục dich su dung
	
	private String stockCode;
	private String stage;
	
	public ReportVTDCDto() {
		super();
		this.materialCode = "";
		this.materialName = "";
		this.unit = "";
		this.amountFinalBeforeStage = BigDecimal.ZERO;
		this.quantity = BigDecimal.ZERO;
		this.note = "";
		this.stockCode = "";
		this.stage = "";
	}
	
	
}
