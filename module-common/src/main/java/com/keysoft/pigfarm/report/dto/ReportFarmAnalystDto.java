package com.keysoft.pigfarm.report.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class ReportFarmAnalystDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private Integer errorStatus;
	
	private String sourceFarmCode;
	private String sourceFarmName;
	
	private Integer sumAmount;
	private BigDecimal sumWeight;
	private BigDecimal averageWeight;
	private LocalDate entryDate;
	
	private List<SubFarmAnalystDto> subFarmAnalysts;
	
	// For searching
	private String stockCode;
	private String barnCode;
	private String processOrderCode;
	private String stage;
	private String pigLevel;
	
	private String displayEntryDate;
  	public String getDisplayEntryDate() {
  		if (entryDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(entryDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	//for caculate
  	private Integer ageWeek;		//tuần tuổi
}
