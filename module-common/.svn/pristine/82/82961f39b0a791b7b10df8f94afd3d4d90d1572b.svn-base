package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MaterialSupportDto {
	private Long id;
  	private String code;
  	private String name;
  	private String unit;
  	private String unsignedName;
  	private Map<String, Object> unitConversion;
  	private List<UnitConversionDto> unitConversions;
  	private boolean selected;
  	private String materialCodeSelected;
  	private String farmCode;
  	private String batch;
  	private String suggestName;
  	private String fastCode;
	private String industryStandardDescription;
  	private String status;
  	private BigDecimal totalRetainedQuantity;
  	private LocalDate postingDate;
}
