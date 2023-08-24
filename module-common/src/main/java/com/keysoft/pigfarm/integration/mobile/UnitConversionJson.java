package com.keysoft.pigfarm.integration.mobile;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitConversionJson {
	@JsonProperty("numerator")
	private Integer numerator;
	
	@JsonProperty("denominator")
	private Integer denominator;
	
	@JsonProperty("meinh")
	private String meinh;
	
	@JsonProperty("meinht")
	private String meinht;
	
	@JsonProperty("quantity")
	private BigDecimal quantity;
}
