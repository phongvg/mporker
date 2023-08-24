package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ReportInstockPigSummaryDto {
	private BigDecimal totalAmountEarlyStage;	//tồn đầu kỳ
	private BigDecimal totalAmountFinalStage;	//tồn cuối kỳ
	private BigDecimal totalAmountEntry;			//heo nhập
	private BigDecimal totalAmountDead;			//heo chết
	private BigDecimal totalAmountCulling;		//heo loại
	private BigDecimal totalAmountSell;			//số bán
	private BigDecimal totalAmountIssue;			//số điều chuyển
	private BigDecimal totalAmountIssueInFarm;	//số điều chuyển trong trại khác lệnh
	
	private List<ReportInstockPigDto> listItem;
	
	public ReportInstockPigSummaryDto() {
		this.totalAmountEarlyStage = new BigDecimal(0);
		this.totalAmountFinalStage = new BigDecimal(0);
		this.totalAmountEntry = new BigDecimal(0);
		this.totalAmountDead = new BigDecimal(0);
		this.totalAmountCulling = new BigDecimal(0);
		this.totalAmountSell = new BigDecimal(0);
		this.totalAmountIssue = new BigDecimal(0);
		this.totalAmountIssueInFarm = new BigDecimal(0);
	}
}
