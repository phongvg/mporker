package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportDayDetailDto {
	private String stockCode;
	private String barnCode;
	private String stage;
	private String poCode;
	private String pigType;
	private LocalDate receivedDate;
	private String fromStockCode;
	private String fromStockName;
	private Integer importedAmount;
	private BigDecimal importedWeight;
	private BigDecimal importedAverage;
	private Integer amountPigEntry;    // Nhap dan trong ngay
	private BigDecimal amountSales; // So luong ban heo
	private BigDecimal amountGIDoCode; // So luong heo dieu chuyen
	private BigDecimal amountGIPOCode; // So luong heo chuyen lenh
	private Integer sumAmountEarly;  // ton dau ky
	private Integer sumAmountFinal;  // ton cuoi ky
	private BigDecimal sumAmountFeed; // tong cam an
	private BigDecimal sumAmountPigDead;  // tong so chet trong ngay
	private BigDecimal sumAmountPigCulling;
	private Integer	 actualTotalEntryQuantity;	//sl nhập đàn thực tế
	
	private Integer accumulatedDead;		//số con chết lũy kế
	private BigDecimal deadRatio;			//tỷ lệ chết
	
	private BigDecimal feedInPig;
	private BigDecimal feedInPigStandard;
	private String feedInPigDiff;  // chenh lech tc
	private LocalDate reportDate;
	private String displayReportDate;
  	public String getDisplayReportDate() {
  		if (reportDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(reportDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayReceiveDate;
  	public String getDisplayReceiveDate() {
  		if (receivedDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(receivedDate);  
  		} else {
  			return null;
  		}
  	}
  	
	//searching
	private LocalDate startDate;
	private String startDateStr;
	private LocalDate endDate;
	private String endDateStr;
	private String processOrderCode;
	
	//caculate
	private Integer ageWeek;			//tuần tuổi
}
