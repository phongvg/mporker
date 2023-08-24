package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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
public class InstockBaselineDto extends BaseDto {
	private Long id;
  	private String stockCode;
  	private String transCode;
  	private LocalDate syncDate;
  	private Map<String, Object> content;
  	private boolean latest;
  	private StockDto stock;
  	private String username;
  	private String farmCode;
  	private String farmName;
  	private boolean latestOfDay;
  	private LocalDateTime createdDate;
  	
  	private String displaySyncDate;
  	public String getDisplaySyncDate() {
  		if (createdDate != null) {
  			return DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY__HH_MM_SS.pattern).format(createdDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String syncDateSearch;
  	private List<MaterialDetailBaselineDto> materialDetails;
}
