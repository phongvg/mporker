package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class SubFarmAnalystDto {
	
	private Integer feedDay;									//ngày nuôi
	private BigDecimal sumAmountFeed;							//tổng cám ăn thực tế
	private BigDecimal sumStandardAmountFeed;					//tổng cám ăn tiêu chuẩn
	private Integer pigRetained;							
		
	private BigDecimal feedInPig;								//cám ăn thực tế/con/ngày
	private BigDecimal standardFeedInPig;						//căm ăn tiêu chuẩn/con/ngày
	
	private BigDecimal amountDead;
	private BigDecimal deadRate;
	
	private BigDecimal standardAverageWeightInPig;				//trọng lượng TB/con/ngày
	private LocalDate entryDate;
	private String weekOfYear;
	
	private BigDecimal avgWeightEstimate;
	
	private String displayEntryDate;
  	public String getDisplayEntryDate() {
  		if (entryDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(entryDate);  
  		} else {
  			return null;
  		}
  	}
}
