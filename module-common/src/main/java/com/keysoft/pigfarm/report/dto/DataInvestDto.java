package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.SymbolEnum;

import lombok.Data;

@Data
public class DataInvestDto {
	private String processOrderCode;
	private String barnName;
	private String farmCode;
	private String farmName;
	private LocalDate startDate;
	private LocalDate nearestGA;			//ngày xuất tiêu hao gần nhất so với ngày xem báo cáo
	private BigDecimal evaluteAmount;		//số lượng đánh giá
	private LocalDate nearesrWeightNote;	//ngày tạo phiếu ghi nhận trọng lượng gần nhất
	private String earlyProcessOrder;		//lệnh sx lứa trước
	private String pigLevel;				//Lứa heo
	
	//searching
	private String stage;				//tìm kiếm theo ngày
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
  	
  	private String displayStartDate;
  	public String getDisplayStartDate() {
  		if (startDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(startDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayNearestGA;
  	public String getDisplayNearestGA() {
  		if (nearestGA != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(nearestGA);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayNearesrWeightNote;
  	public String getDisplayNearesrWeightNote() {
  		if (nearesrWeightNote != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(nearesrWeightNote);  
  		} else {
  			return null;
  		}
  	}
}
