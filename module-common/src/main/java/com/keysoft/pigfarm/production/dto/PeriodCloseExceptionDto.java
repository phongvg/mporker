package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PeriodCloseExceptionDto extends BaseDto {
	
	private Long id;
  	private String farmCode;
  	private LocalDate fromDate;
  	private LocalDate toDate;
  	private String funcType;
  	private LocalDateTime createdDate;
  	private LocalDateTime modifiedDate;
  	private String createdBy;
  	private String modifiedBy;
  	
  	private String displayFromDate;
  	public String getDisplayFromDate() {
  		if (fromDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(fromDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayToDate;
  	public String getDisplayToDate() {
  		if (toDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(toDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	//search
  	private String username;
  	private List<String> farmCodes;
  	private String periodCloseStage;
}
