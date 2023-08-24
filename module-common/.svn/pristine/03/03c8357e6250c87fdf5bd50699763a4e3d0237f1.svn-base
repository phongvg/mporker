package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WeightNoteDto {
	private BigDecimal averageWeight;
	private List<WeightChartDto> weightCharts;
	
	// for report
	private BigDecimal sumQuantity;
	private BigDecimal sumWeight;
	private String barnName;
	private String barnCode;
	private String processOrderCode;
	private String pigType;
	private String createdDate;
}
