package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.BaseDto;
import com.keysoft.pigfarm.common.DatePatternEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InstockAdjustmentDto extends BaseDto{
	private Long id;
  	private String transCode;
  	private String status;
   	private LocalDate postingDate;
  	private String type;
  	private String createdBy;
  	private LocalDateTime createdDate;
  	private String modifiedBy;
  	private LocalDateTime modifiedDate;
 	private StockDto stock;
 	private String username;
 	private List<MaterialDetailDto> materialDetails;
 	private String stockName;
 	private String stockCode;
 	
 	private String displayPostingDate;
  	public String getDisplayPostingDate() {
  		if (postingDate != null) {
  			return DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(postingDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayCreatedDate;
  	public String getDisplayCreatedDate() {
  		if (createdDate != null) {
  			return DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY__HH_MM_SS.pattern).format(createdDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private List<LocalDate> periodLocalDates;
}
