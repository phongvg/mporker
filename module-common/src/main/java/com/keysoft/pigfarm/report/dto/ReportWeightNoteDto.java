package com.keysoft.pigfarm.report.dto;

import java.math.BigDecimal;
import java.util.List;

import com.keysoft.pigfarm.production.dto.WeightNoteDailyDto;
import com.keysoft.pigfarm.production.dto.WeightNoteDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ReportWeightNoteDto {
	private List<WeightNoteDailyDto> weightNotes;
	private Integer totalQuantityLatest;
	private Integer totalWeightLatest;
	private BigDecimal totalAvgWeightLatest;
	
	private Integer totalQuantityEarly;
	private Integer totalWeightEarly;
	private BigDecimal totalAvgWeightEarly;
}
