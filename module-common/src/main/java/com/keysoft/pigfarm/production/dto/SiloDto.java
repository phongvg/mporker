package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class SiloDto extends BaseDto{
	private Long id;
  	private BigDecimal amount;
    private BarnDto barn;
  	private Map<String, Object> content;
  	private String createdBy;
  	private LocalDateTime createdDate;
  	private String modifiedBy;
  	private LocalDateTime modifiedDate;
  	private String username;
  	private String transCode;
  	
  	private String farmCode ;
  	
  	
  	private String createdDateDisplay; 
    public String getCreatedDateDisplay() {
    	if (createdDate != null) {
    		return DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(createdDate);	
    	} else {
    		return "";
    	}
    }
    
    private String  modifiedDateDisplay;
  	
    public String getModifiedDateDisplay() {
    	if (modifiedDate != null) {
    		return DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(modifiedDate);	
    	} else {
    		return "";
    	}
    }
  	
}
