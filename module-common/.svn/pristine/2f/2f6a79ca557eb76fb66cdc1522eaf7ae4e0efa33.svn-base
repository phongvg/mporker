package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;
import com.keysoft.pigfarm.production.dto.PigEntryDto;

import lombok.Data;

@Data
public class ReportProdResultDto {
	private String pigLevel;
	private String processOrderCode;
	private String barnCode;
	private String farmCode;
	private String farmName;
	
	private String sourceEntry;					//nguồn nhập
	private LocalDate entryDate;
	private Integer entryQuantity;
	private BigDecimal entryVolumn;				//tổng trọng lượng nhập
	private BigDecimal averageEntryVolumn;		//trọng lượng nhập TB
	private LocalDate emptyPigDate;				//ngày hết heo
	private Integer dayFeeds;					//số ngày nuôi
	private Integer exportQuantity;				//số con xuất
	private BigDecimal exportVolumn;			//trọng lượng xuất
	private BigDecimal avgExportVolumn;			//trọng lượng xuất TB
	private Integer deadQuantity;
	private BigDecimal deadRatio;
	private Integer cullingQuantity;
	private BigDecimal feedTotal;				//tổng cám sử dụng
	
	private BigDecimal fcrReality;
	private BigDecimal fcrStandard;
	private BigDecimal fcrDiff;
	private BigDecimal adg;
	
	//caculate
	private Boolean isEvaluated;				//check đã có thông tin đánh giá heo
	private String pigType;
	private LocalDate poStartDate;
	private Integer totalEntryQuantity;			//tổng số heo nhập tính từ sự kiện pigentry
	private BigDecimal totalEntryVolumn;		//tổng khối lượng heo nhập tính từ sự kiện pigentry
	private List<PigEntryDto> listPigEntry;
	
	//searching
	private String fromDate;
	private String toDate;
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
  	
  	private String displayEmptyDate;
  	public String getDisplayEmptyDate() {
  		if (emptyPigDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(emptyPigDate);  
  		} else {
  			return null;
  		}
  	}
}
