package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GoodsAttritionSupportDto extends BaseDto{
	private Long id;
  	private String processOrderCodes;
  	private LocalDate createdDate;
  	private StockDto stock;
  	private Integer ratio;
	private Integer total;
	private String username;
	
	private String displayPostingDate;
  	public String getDisplayPostingDate() {
  		if (createdDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(createdDate);  
  		} else {
  			return null;
  		}
  	}
  	
	private String  postingDateSearch;
  	private LocalDate startDate;
  	private LocalDate endDate;
	private String searchFromDate;
	private String searchToDate;
  	private String stockName;
}