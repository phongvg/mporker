package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;
import com.keysoft.pigfarm.production.dto.PigEntryDto;

import lombok.Data;

@Data
public class ReportProdEstimateDto {
	private String pigLevel;					//Lứa heo
	private String processOrderCode;			//chứa lệnh sx trong TH tính toán theo lệnh, chứa nhiều lệnh trong TH tính toán theo lứa heo
	private String barnCode;
	private String farmCode;
	private String farmName;
	
	private String sourceEntry;					//nguồn nhập
	private LocalDate entryDate;
	private Integer entryQuantity;
	private BigDecimal entryVolumn;				//tổng trọng lượng nhập
	private BigDecimal averageEntryVolumn;		//trọng lượng nhập TB
	private Integer dayFeeds;					//số ngày nuôi
	private BigDecimal ageDay;						//số ngày tuổi
	private BigDecimal feedTotal;				//tổng cám sử dụng
	private Integer pigEstimate;				//số con ước tính
	private BigDecimal totalVolumnEstimate;		//tổng trọng lượng ước tính
	private BigDecimal averageVolumnEstimate;	//trọng lượng ước tính trung bình
	private Integer issueQuantity;				//số lượng điều chuyển
	private BigDecimal issueVolumn;				//trọng lượng điều chuyển
	private Integer soldQuantity;				//số lượng bán
	private BigDecimal soldVolumn;				//trọng lượng bán
	private BigDecimal averageVolumn;			//trọng lượng TB dự kiến
	private Integer deadQuantity;
	private BigDecimal deadRatio;
	private BigDecimal fcrEstimate;
	private BigDecimal fcrStandard;
	private BigDecimal fcrDiff;
	private BigDecimal adg;
	private BigDecimal standardWeight;
	private Integer culling7DayAmount;		//số lượng loại 7 ngày
	
	//caculate
	private String pigType;
	private LocalDate poStartDate;
	private Boolean checkEvaluateAmount = false;
	private Boolean checkEvaluateVolumn = false;
	private Integer totalEntryQuantity;			//tổng số con nhập đàn từ sk nhập đàn
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
