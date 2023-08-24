package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.DatePatternEnum;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Generated by Speed Generator
 * 
 * @author <a href="mailto:ngtrungkien@gmail.com">Kien Nguyen</a>
 */
@Data
@SuperBuilder
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QuotaDto {
	private Long id;
	private Integer day;
  	private String materialCode;
  	private String materialName;
  	private Integer quantity;
 	private LocalDate requestDate;
 	private String batch ;
 	private LocalDate manufacturedDate;	
	private LocalDate expiredDate;
	private LocalDateTime createdDate; 
	private ProcessOrderDto processOrder;
	private boolean latest;	
	private String unit;
	private MaterialDto material;
	private List<String> batchs;
	
	private String displayRequestDate;
	public String getDisplayRequestDate() {
		return requestDate != null ? DateTimeFormatter.ofPattern("dd-MM-yyyy").format(requestDate) : ""; 
  	}  	
	
	private String displayManufacturedDate;
	public String getDisplayManufacturedDate() {
		return manufacturedDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_1.pattern).format(manufacturedDate) : "";
	}
	
	private String displayExpiredDate;
	public String getDisplayExpiredDate() {
		return expiredDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_1.pattern).format(expiredDate) : "";
	}
}