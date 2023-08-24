package com.keysoft.pigfarm.production.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WeightChartDailyDto {
	// for report
	private String range;
	private Integer quantityLatest;
	private Integer weightLatest;
	
	private Integer quantityEarly;
	private Integer weightEarly;
}
