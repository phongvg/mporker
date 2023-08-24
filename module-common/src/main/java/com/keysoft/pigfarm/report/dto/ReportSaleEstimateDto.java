package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;

import lombok.Data;

@Data
public class ReportSaleEstimateDto {
	private String processOrderCode;
	private String barnCode;
	private String farmCode;
	
	private Integer totalSale;
	private BigDecimal avgWeight;
	private BigDecimal greater100Ratio;
	private String pigType;
	private Integer greater130;
	private Integer greater120;
	private Integer greater110;
	private Integer greater100;
	private Integer greater90;
	private Integer greater80;
	private Integer greater70;
	private Integer less70;
	private Integer issue;
	
	//caculating
	private Integer greater100Quantity;		//số lượng trên 100
	
	//searching
	private String stage;					//thời gian tìm kiếm
	private String fromDate;
	private String toDate;
	private List<String> farmCodes;			//tìm kiếm theo nhiều mã trại
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
