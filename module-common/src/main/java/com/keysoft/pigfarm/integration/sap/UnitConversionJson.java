package com.keysoft.pigfarm.integration.sap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitConversionJson {
	@JsonProperty("NUMERATOR")
	private Integer numerator;
	@JsonProperty("DENOMINATOR")
	private Integer denominator;
	@JsonProperty("MEINH")
	private String meinh;
	@JsonProperty("MEINHT")
	private String meinht;
}
