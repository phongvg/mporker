package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;

import lombok.Data;

@Data
public class ReportInstockPigDto {
	private String processOrderCode;
	private String pigType;
	private String barnCode;
	private String farmCode;
	private String farmName;
	
	private BigDecimal amountEarlyStage;	//tồn đầu kỳ
	private BigDecimal amountFinalStage;	//tồn cuối kỳ
	private BigDecimal amountEntry;			//heo nhập
	private BigDecimal amountDead;			//heo chết
	private BigDecimal amountCulling;		//heo loại
	private BigDecimal amountSell;			//số bán
	private BigDecimal amountIssue;			//số điều chuyển
	private BigDecimal amountIssueInFarm;	//số điều chuyển trong trại khác lệnh
	
	//searching
	private String dateStringPeriod;		//tìm kiếm theo khoảng thời gian
	private String fromDate;
	private String toDate;
	private List<String> farmCodes;			//tìm kiếm theo nhiều mã trại
	private List<String> barnCodes;			//tìm kiếm theo nhiều mã chuồng
	
	private String barnCodeStr;
	private String farmCodeString;
	private String farmCodesStr;
  	public String getFarmCodesStr() {
  		if (farmCodes != null) {
  			  StringBuilder temp = new StringBuilder();
  			  for(String s : farmCodes) {
  				temp = temp.append(s).append(SymbolEnum.COMMA.val);
  			  }
  			  return temp.toString();
  		} else {
  			return null;
  		}
  	}

}
