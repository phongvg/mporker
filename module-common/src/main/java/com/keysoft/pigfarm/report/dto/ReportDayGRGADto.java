package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.keysoft.pigfarm.production.dto.DayDetailDto;

import lombok.Data;

@Data
public class ReportDayGRGADto {
	private String materialCode;
	private String materialName;
	private String materialUnit;
	
	private BigDecimal earlyQuantity;			//tồn đầu
	private List<DayDetailDto> listDdays;
	private BigDecimal totalReceiptQuantity;	//tổng nhập
	private BigDecimal totalIssueQuantity;		//tổng xuất
	private BigDecimal finalQuantity;			//tồn cuối
	
	//for searching
	private String farmCode;
	private String stage;
	private String fromDate;
	private String toDate;
	private List<String> purchaseGroups;		//nhóm mua
	
	//for caculating
	private Map<LocalDate, DayDetailDto> mapDateToDetail;
	
	private String purchasingGroupsStr;
	public String getPurchasingGroupsStr() {
  		if (purchaseGroups != null) {
  			StringBuilder newStr = new StringBuilder();
  			
  			purchaseGroups.stream().forEach(newStr::append);
  			return newStr.toString();
  		} else {
  			return null;
  		}
  	}
}
