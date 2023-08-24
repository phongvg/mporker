package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;
import com.keysoft.pigfarm.production.dto.PigEntryDto;

import lombok.Data;

@Data
public class ReportWeightCompareDto {
	private String processOrderCode;
	private String pigLevel;
	private String pigType;
	private String barnCode;
	private String farmCode;
	private String batch;
	
	private BigDecimal amountStage;			//số lượng tồn heo
	private LocalDate entryDate;			//ngày nhập đầu = ngày bắt đầu lệnh
	private Integer dayFeeds;				//số ngày nuôi
	private BigDecimal ageDay; 				//ngày tuổi
	private BigDecimal standardWeight;		//trọng lượng tiêu chuẩn
	private BigDecimal estimateWeight;		//trọng lượng ước tính
	private BigDecimal diffAmount; 			//chênh lệch
	
	//caculate
	private BigDecimal totalEntryVolumn;	//tổng khối lượng nhập
	private BigDecimal totalEntry;			//tổng số nhập
	
	private LocalDate poStartDate;			//ngày bắt đầu lệnh
	
	private BigDecimal totalQuantity;		//số lượng ước tính
	private BigDecimal totalWeight;			//khối lượng ước tính
	private List<PigEntryDto> listPigEntry;
	
	//searching
	private String stage;					//thời gian tìm kiếm
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
  	
  	private String displayEntryDate;
  	public String getDisplayEntryDate() {
  		if (entryDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(entryDate);  
  		} else {
  			return null;
  		}
  	}
}
