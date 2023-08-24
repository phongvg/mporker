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
public class WeightNoteDailyDto {
	private String barnName;
	private String barnCode;
	private String processOrderCode;
	private String pigType;
	private List<WeightChartDailyDto> weightCharts;
	
	//for report
	private BigDecimal averageWeightLatest;
	private BigDecimal sumQuantityLatest;
	private BigDecimal sumWeightLatest;
	private String createdDateLatest;
	
	private BigDecimal averageWeightEarly;
	private BigDecimal sumQuantityEarly;
	private BigDecimal sumWeightEarly;
	private String createdDateEarly;
}
