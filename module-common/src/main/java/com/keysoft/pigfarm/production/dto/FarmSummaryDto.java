package com.keysoft.pigfarm.production.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class FarmSummaryDto {
	
	private Long id;
	private Integer totalFarms;
	private Integer totalFarmsRent;
	private Integer totalFarmsManufactured;
	private Integer totalPigs;
	private Integer totalPigCulling;
	
	private FarmDto farmDto;
	private String farmId;
	
}
