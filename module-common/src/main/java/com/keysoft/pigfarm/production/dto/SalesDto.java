package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
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
public class SalesDto extends BaseDto{
	private Long id;
	private StockDto stock;
	private LocalDate postingDate;
	private String processOrderCode;
	private String batch;
	private String status;
	private String materialCode;
	private BigDecimal quantity;
	private BigDecimal weight;
	private String weightUnit;
	private String unit;
	private LocalDateTime createdDate;
	private String stockName;
  	private String username;
  	private BigDecimal distributionChannel;
  	
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
  	
  	// for searching postingDate 
  	private LocalDate startDate;
  	private LocalDate endDate;
  	
  	private String fromDate;
  	private String toDate;
  	private String postingDateSearch;
  	private List<LocalDate> recordDateSearchPeriod;
}
